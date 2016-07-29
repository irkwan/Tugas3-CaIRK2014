using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsFormsApplication1
{
    public class Puzzle
    {
        private String[] dictionary;
        private char[,] table;
        private int[] indexDictionary;
        private ArrayList foundWords;
        private int point;

        //Inisialisasi puzzle dan kamus
        public Puzzle()
        {
            //Membaca file input dictionary, menyimpan ke memori, dan melakukan pengindeks-an
            Scanner bufferDictionary = new Scanner(new File("dictionary.txt"));
            dictionary = new String[110000];
            indexDictionary = new int[27];
            char cap = '#';
            int k = 0;
            while (bufferDictionary.hasNextLine())
            {
                dictionary[k] = bufferDictionary.nextLine();
                //Pengindeks-an abjad agar pencarian lebih cepat
                if (dictionary[k].charAt(0) != cap)
                {
                    cap = dictionary[k].charAt(0);
                    indexDictionary[((int)cap - 97)] = k;
                }
                k++;
            }

            //Membaca file input puzzle wordament 4x4 dan menyimpannya ke memori
            Scanner input = new Scanner(new File("puzzle.txt"));
            String temp = new String("");
            table = new char[4, 4];
            for (int j = 0; j < 4; j++)
            {
                for (int i = 0; i < 4; i++)
                {
                    temp = input.next();
                    table[i, j] = temp.charAt(0);
                }
            }
            point = 0;
            foundWords = new ArrayList();
            solve();
        }

        //Menjelajahi seluruh kombinasi kata yang mungkin pada puzzle
        public void solve()
        {
            //Tabel Tc menunjukan huruf yang sudah pernah dikunjungi
            boolean[,] Tc = new boolean[4, 4]{
		    {false, false, false, false},
		    {false, false, false, false},
		    {false, false, false, false},
		    {false, false, false, false}
		    };
            String current = new String("");
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    iterateFrom(i, j, Tc, current);
                }
            }
        }

        //Mengiterasi kemungkinan kata dari suatu posisi
        public void iterateFrom(int x, int y, boolean[,] _Tc, String S)
        {
            if (isValidIndex(x, y) && _Tc[x, y] == false)
            {
                String current_string = new String(S);
                current_string = current_string + table[x, y];

                //Cek apakah kta ada dikamus dan belum pernah ditebak sebelumnya
                if (isExist(current_string) && !foundWords.contains(current_string))
                {
                    point++;
                    foundWords.add(current_string);
                }
                boolean[,] Tc2 = new boolean[4, 4];
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
        private boolean isValidIndex(int x, int y)
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
        private boolean isExist(String S)
        {
            boolean found = false;
            int x = (int)S.charAt(0) - 97;
            int i = indexDictionary[x];
            while (!found && i < indexDictionary[x + 1])
            {
                if (dictionary[i].equals(S))
                {
                    found = true;
                }
                i++;
            }
            return found;
        }

        //Mengecek apakah kata merupakan pefix dari kata lain
        private boolean isPrefix(String S)
        {
            boolean found = false;
            int x = (int)S.charAt(0) - 97;
            int i = indexDictionary[x];
            while (!found && i < indexDictionary[x + 1])
            {
                if (dictionary[i].startsWith(S))
                {
                    found = true;
                }
                i++;
            }
            return found;
        }
    }
}
