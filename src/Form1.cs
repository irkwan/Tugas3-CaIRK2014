using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Diagnostics;

namespace WordamentHelper
{
    using System.Threading;
    public partial class Form1 : Form
    {
        public Form1()
        {
            invokeCount = 1200;
            InitializeComponent();
            var th1 = new Thread(TimerTick);
            th1.Start();
        }

        public void TimerTick(Object stateInfo)
        {
            while (true)
            {
                System.Threading.Thread.Sleep(95);
                string text = (invokeCount / 10).ToString() + "." + (invokeCount % 10).ToString();
                SetText(text);
            }
        }
        delegate void SetTextCallback(string text);
        private void SetText(string text)
        {
            // InvokeRequired required compares the thread ID of the
            // calling thread to the thread ID of the creating thread.
            // If these threads are different, it returns true.
            if (this.textBox17.InvokeRequired)
            {
                SetTextCallback d = new SetTextCallback(SetText);
                this.Invoke(d, new object[] { text });
            }
            else
            {
                this.textBox17.Text = text;
            }
        }
        private void button1_Click(object sender, EventArgs e)
        {
            invokeCount = 1200;
            // Create timer
            // Have the timer fire repeated events (true is the default)
            aTimer.AutoReset = true;
            // Start the timer
            aTimer.Enabled = true;
            //Get table

            char[] input = new char[16];
            input[0] = Char.ToLower(textBox1.Text.ElementAt(0));
            input[1] = Char.ToLower(textBox2.Text.ElementAt(0));
            input[2] = Char.ToLower(textBox3.Text.ElementAt(0));
            input[3] = Char.ToLower(textBox4.Text.ElementAt(0));
            input[4] = Char.ToLower(textBox5.Text.ElementAt(0));
            input[5] = Char.ToLower(textBox6.Text.ElementAt(0));
            input[6] = Char.ToLower(textBox7.Text.ElementAt(0));
            input[7] = Char.ToLower(textBox8.Text.ElementAt(0));
            input[8] = Char.ToLower(textBox9.Text.ElementAt(0));
            input[9] = Char.ToLower(textBox10.Text.ElementAt(0));
            input[10] = Char.ToLower(textBox11.Text.ElementAt(0));
            input[11] = Char.ToLower(textBox12.Text.ElementAt(0));
            input[12] = Char.ToLower(textBox13.Text.ElementAt(0));
            input[13] = Char.ToLower(textBox14.Text.ElementAt(0));
            input[14] = Char.ToLower(textBox15.Text.ElementAt(0));
            input[15] = Char.ToLower(textBox16.Text.ElementAt(0));
            Puzzle myPuzzle = new Puzzle();
            myPuzzle.solve(input);
            listView1.BeginUpdate();
            listView1.Items.Clear();
            label5.Text = "";
            label6.Text = "";
            int k = 0;
            for (int i = 0; i < myPuzzle.foundWords.Count; i++)
            {
                listView1.Items.Add(i.ToString());
                listView1.Items[i].SubItems.Add(myPuzzle.foundWords[i]);
                k += myPuzzle.foundWords[i].Length;
            }

            label5.Text = myPuzzle.foundWords.Count.ToString();
            label6.Text = k.ToString();
            listView1.EndUpdate();
            //stop timer
            aTimer.AutoReset = false;
            aTimer.Enabled = false;
        }
        private void button2_Click(object sender, EventArgs e)
        {
            invokeCount = 1200;
            textBox17.Text = "120.0";
            Random rnd = new Random();
            listView1.Items.Clear();
            label5.Text = "";
            label6.Text = "";
            int randomChar = rnd.Next(26);
            textBox1.Text = ((char)(randomChar + 97)).ToString();
            randomChar = rnd.Next(26);
            textBox2.Text = ((char)(randomChar + 97)).ToString();
            randomChar = rnd.Next(26);
            textBox3.Text = ((char)(randomChar + 97)).ToString();
            randomChar = rnd.Next(26);
            textBox4.Text = ((char)(randomChar + 97)).ToString();
            randomChar = rnd.Next(26);
            textBox5.Text = ((char)(randomChar + 97)).ToString();
            randomChar = rnd.Next(26);
            textBox6.Text = ((char)(randomChar + 97)).ToString();
            randomChar = rnd.Next(26);
            textBox7.Text = ((char)(randomChar + 97)).ToString();
            randomChar = rnd.Next(26);
            textBox8.Text = ((char)(randomChar + 97)).ToString();
            randomChar = rnd.Next(26);
            textBox9.Text = ((char)(randomChar + 97)).ToString();
            randomChar = rnd.Next(26);
            textBox10.Text = ((char)(randomChar + 97)).ToString();
            randomChar = rnd.Next(26);
            textBox11.Text = ((char)(randomChar + 97)).ToString();
            randomChar = rnd.Next(26);
            textBox12.Text = ((char)(randomChar + 97)).ToString();
            randomChar = rnd.Next(26);
            textBox13.Text = ((char)(randomChar + 97)).ToString();
            randomChar = rnd.Next(26);
            textBox14.Text = ((char)(randomChar + 97)).ToString();
            randomChar = rnd.Next(26);
            textBox15.Text = ((char)(randomChar + 97)).ToString();
            randomChar = rnd.Next(26);
            textBox16.Text = ((char)(randomChar + 97)).ToString();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
}
