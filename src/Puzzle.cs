using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.IO;

namespace WordamentHelper
{
    class Puzzle
    {
        private String[] dictionary;
        private char[,] table;
        private int[] indexDictionary;
        public List<string> foundWords;
        private int point;
        private int maxIndex;

        //Inisialisasi puzzle dan kamus
        public Puzzle()
        {
            //Membaca file input dictionary, menyimpan ke memori, dan melakukan pengindeks-an
            StreamReader bufferDictionary = new StreamReader("dictionary.txt");
            dictionary = new String[110000];
            indexDictionary = new int[27];
            char cap = '#';
            int k = 0;
            while (!bufferDictionary.EndOfStream)
            {
                dictionary[k] = bufferDictionary.ReadLine();
                //Pengindeks-an abjad agar pencarian lebih cepat
                if (dictionary[k].ElementAt(0) != cap)
                {
                    if (dictionary[k].ElementAt(0) > cap)
                    {
                        cap = dictionary[k].ElementAt(0);
                        indexDictionary[((int)cap - 97)] = k;
                    }
                    else if (cap == 'z')
                    {
                        cap++;
                        indexDictionary[((int)cap - 97)] = k;
                        
                    }
                }
                k++;
            }
            maxIndex = k;
            point = 0;
            table = new char[4, 4];
        }

        //Menjelajahi seluruh kombinasi kata yang mungkin pada puzzle
        public void solve(char[] inp)
        {
            //Membaca file input puzzle wordament 4x4 dan menyimpannya ke memori
            char temp = 'a';
            for (int j = 0; j < 4; j++)
            {
                for (int i = 0; i < 4; i++)
                {
                    table[i, j] = inp[j*4 + i];
                }
            }

            foundWords = new List<string>();
            //Tabel Tc menunjukan huruf yang sudah pernah dikunjungi
            bool[,] Tc = new bool[4, 4]{
		    {false, false, false, false},
		    {false, false, false, false},
		    {false, false, false, false},
		    {false, false, false, false}
		    };
            string current = "";
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    iterateFrom(i, j, Tc, current);
                }
            }
        }

        //Mengiterasi kemungkinan kata dari suatu posisi
        public void iterateFrom(int x, int y, bool[,] _Tc, string S)
        {
            if (isValidIndex(x, y) && _Tc[x, y] == false)
            {
                string current_string;
                current_string = String.Copy(S);
                current_string = current_string + table[x, y];

                //Cek apakah kta ada dikamus dan belum pernah ditebak sebelumnya
                if (isExist(current_string) && !foundWords.Contains(current_string))
                {
                    point++;
                    foundWords.Add(current_string);
                }
                bool[,] Tc2 = new bool[4, 4];
                for (int i = 0; i < 4; i++)
                {
                    for (int j = 0; j < 4; j++)
                    {
                        Tc2[i, j] = _Tc[i, j];
                    }
                }
                Tc2[x, y] = true;

                //Jika kata yang ditemukan merupakan prefix dari suatu kata lain, 
                //maka lanjutkan pencarian.
                if (isPrefix(current_string))
                {
                    iterateFrom(x - 1, y - 1, Tc2, current_string);
                    iterateFrom(x, y - 1, Tc2, current_string);
                    iterateFrom(x + 1, y - 1, Tc2, current_string);
                    iterateFrom(x - 1, y, Tc2, current_string);
                    iterateFrom(x + 1, y, Tc2, current_string);
                    iterateFrom(x - 1, y + 1, Tc2, current_string);
                    iterateFrom(x, y + 1, Tc2, current_string);
                    iterateFrom(x + 1, y + 1, Tc2, current_string);
                }
            }
            else
            {
                //do nothing
            }
        }
        private bool isValidIndex(int x, int y)
        {
            if (x < 4 && x >= 0 && y < 4 && y >= 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        //Mengecek apakah kata terdapat pada kamus
        private bool isExist(string S)
        {
            bool found = false;
            int x = (int)S.ElementAt(0) - 97;
            int i = indexDictionary[x];
            while (!found && i < indexDictionary[x + 1])
            {
                if (dictionary[i].Equals(S))
                {
                    found = true;
                }
                i++;

            }
            i = indexDictionary[26];
            while (!found && i < maxIndex)
            {
                if (dictionary[i].Equals(S))
                {
                    found = true;
                }
                i++;
            }
            
            return found;
        }

        //Mengecek apakah kata merupakan pefix dari kata lain
        private bool isPrefix(string S)
        {
            bool found = false;
            int x = (int)S.ElementAt(0) - 97;
            int i = indexDictionary[x];
            while (!found && i < indexDictionary[x+1])
            {
                if (dictionary[i].StartsWith(S))
                {
                    found = true;
                }
                i++;
            }
            
            i = indexDictionary[26];
            while (!found && i < maxIndex)
            {
                if (dictionary[i].StartsWith(S))
                {
                    found = true;
                }
                i++;
            }
            return found;
        }
    }
}
