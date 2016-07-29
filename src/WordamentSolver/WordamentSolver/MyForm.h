#pragma once
#include <vcclr.h>
#include <vector>
#include <string>
#include <locale>
#include <msclr\marshal.h>
#include <fstream>
#include <conio.h>
#include <windows.h>
using namespace std;

vector<string> temp;

namespace WordamentSolver {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;
	using namespace System::Threading;

	/// <summary>
	/// Summary for MyForm
	/// </summary>
	public ref class MyForm : public System::Windows::Forms::Form
	{
		static int second = 120;
		int scores = 0, word_found = 0, count = 0;
		bool finished = false;
	private: System::ComponentModel::BackgroundWorker^  backgroundWorker1;
	private: System::Windows::Forms::Timer^  timer1;

	public:
		MyForm(void)
		{
			InitializeComponent();
			//
			//TODO: Add the constructor code here
			//
		}

	protected:
		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		~MyForm()
		{
			if (components)
			{
				delete components;
			}
		}
	private: System::Windows::Forms::Panel^  panel1;
	protected:
	private: System::Windows::Forms::TextBox^  textBox16;
	private: System::Windows::Forms::TextBox^  textBox15;
	private: System::Windows::Forms::TextBox^  textBox14;
	private: System::Windows::Forms::TextBox^  textBox13;
	private: System::Windows::Forms::TextBox^  textBox12;
	private: System::Windows::Forms::TextBox^  textBox11;
	private: System::Windows::Forms::TextBox^  textBox10;
	private: System::Windows::Forms::TextBox^  textBox9;
	private: System::Windows::Forms::TextBox^  textBox8;
	private: System::Windows::Forms::TextBox^  textBox7;
	private: System::Windows::Forms::TextBox^  textBox6;
	private: System::Windows::Forms::TextBox^  textBox5;
	private: System::Windows::Forms::TextBox^  textBox4;
	private: System::Windows::Forms::TextBox^  textBox3;
	private: System::Windows::Forms::TextBox^  textBox2;
	private: System::Windows::Forms::TextBox^  textBox1;
	private: System::Windows::Forms::Label^  label1;
	private: System::Windows::Forms::Label^  label2;
	private: System::Windows::Forms::Label^  label3;
	private: System::Windows::Forms::Label^  label4;
	private: System::Windows::Forms::Label^  wordsfound;
	private: System::Windows::Forms::Label^  score;
	private: System::Windows::Forms::Label^  remainingtime;
	private: System::Windows::Forms::Button^  solve;
	private: System::Windows::Forms::Button^  clearButton;

	private: System::Windows::Forms::Label^  label5;
	private: System::Windows::Forms::Button^  button1;
	private: System::Windows::Forms::ListView^  listView1;
	private: System::Windows::Forms::ColumnHeader^  columnHeader1;
	private: System::Windows::Forms::ColumnHeader^  columnHeader2;
	private: System::Windows::Forms::Label^  label6;
	private: System::Windows::Forms::MenuStrip^  menuStrip1;
	private: System::Windows::Forms::ToolStripMenuItem^  fileToolStripMenuItem;
	private: System::Windows::Forms::ToolStripMenuItem^  solveToolStripMenuItem;
	private: System::Windows::Forms::ToolStripMenuItem^  clearToolStripMenuItem;
	private: System::Windows::Forms::ToolStripMenuItem^  exitToolStripMenuItem;
	private: System::Windows::Forms::ToolStripMenuItem^  aboutToolStripMenuItem;
	private: System::Windows::Forms::ToolStripMenuItem^  helpToolStripMenuItem;
	private: System::Windows::Forms::ToolStripMenuItem^  aboutToolStripMenuItem1;
	private: System::Windows::Forms::ProgressBar^  progressBar1;

	private: System::Windows::Forms::Label^  label7;

	protected:


	private: System::ComponentModel::IContainer^  components;

	private:
		/// <summary>
		/// Required designer variable.
		/// </summary>


#pragma region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		void InitializeComponent(void)
		{
			this->components = (gcnew System::ComponentModel::Container());
			System::Windows::Forms::ListViewItem^  listViewItem1 = (gcnew System::Windows::Forms::ListViewItem(L""));
			System::Windows::Forms::ListViewItem^  listViewItem2 = (gcnew System::Windows::Forms::ListViewItem(L""));
			this->panel1 = (gcnew System::Windows::Forms::Panel());
			this->textBox16 = (gcnew System::Windows::Forms::TextBox());
			this->textBox15 = (gcnew System::Windows::Forms::TextBox());
			this->textBox14 = (gcnew System::Windows::Forms::TextBox());
			this->textBox13 = (gcnew System::Windows::Forms::TextBox());
			this->textBox12 = (gcnew System::Windows::Forms::TextBox());
			this->textBox11 = (gcnew System::Windows::Forms::TextBox());
			this->textBox10 = (gcnew System::Windows::Forms::TextBox());
			this->textBox9 = (gcnew System::Windows::Forms::TextBox());
			this->textBox8 = (gcnew System::Windows::Forms::TextBox());
			this->textBox7 = (gcnew System::Windows::Forms::TextBox());
			this->textBox6 = (gcnew System::Windows::Forms::TextBox());
			this->textBox5 = (gcnew System::Windows::Forms::TextBox());
			this->textBox4 = (gcnew System::Windows::Forms::TextBox());
			this->textBox3 = (gcnew System::Windows::Forms::TextBox());
			this->textBox2 = (gcnew System::Windows::Forms::TextBox());
			this->textBox1 = (gcnew System::Windows::Forms::TextBox());
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->label2 = (gcnew System::Windows::Forms::Label());
			this->label3 = (gcnew System::Windows::Forms::Label());
			this->label4 = (gcnew System::Windows::Forms::Label());
			this->wordsfound = (gcnew System::Windows::Forms::Label());
			this->score = (gcnew System::Windows::Forms::Label());
			this->remainingtime = (gcnew System::Windows::Forms::Label());
			this->solve = (gcnew System::Windows::Forms::Button());
			this->clearButton = (gcnew System::Windows::Forms::Button());
			this->label5 = (gcnew System::Windows::Forms::Label());
			this->button1 = (gcnew System::Windows::Forms::Button());
			this->listView1 = (gcnew System::Windows::Forms::ListView());
			this->columnHeader1 = (gcnew System::Windows::Forms::ColumnHeader());
			this->columnHeader2 = (gcnew System::Windows::Forms::ColumnHeader());
			this->label6 = (gcnew System::Windows::Forms::Label());
			this->menuStrip1 = (gcnew System::Windows::Forms::MenuStrip());
			this->fileToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->solveToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->clearToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->exitToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->aboutToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->helpToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->aboutToolStripMenuItem1 = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->progressBar1 = (gcnew System::Windows::Forms::ProgressBar());
			this->label7 = (gcnew System::Windows::Forms::Label());
			this->backgroundWorker1 = (gcnew System::ComponentModel::BackgroundWorker());
			this->timer1 = (gcnew System::Windows::Forms::Timer(this->components));
			this->panel1->SuspendLayout();
			this->menuStrip1->SuspendLayout();
			this->SuspendLayout();
			// 
			// panel1
			// 
			this->panel1->Controls->Add(this->textBox16);
			this->panel1->Controls->Add(this->textBox15);
			this->panel1->Controls->Add(this->textBox14);
			this->panel1->Controls->Add(this->textBox13);
			this->panel1->Controls->Add(this->textBox12);
			this->panel1->Controls->Add(this->textBox11);
			this->panel1->Controls->Add(this->textBox10);
			this->panel1->Controls->Add(this->textBox9);
			this->panel1->Controls->Add(this->textBox8);
			this->panel1->Controls->Add(this->textBox7);
			this->panel1->Controls->Add(this->textBox6);
			this->panel1->Controls->Add(this->textBox5);
			this->panel1->Controls->Add(this->textBox4);
			this->panel1->Controls->Add(this->textBox3);
			this->panel1->Controls->Add(this->textBox2);
			this->panel1->Controls->Add(this->textBox1);
			this->panel1->Location = System::Drawing::Point(31, 99);
			this->panel1->Name = L"panel1";
			this->panel1->Size = System::Drawing::Size(171, 131);
			this->panel1->TabIndex = 0;
			// 
			// textBox16
			// 
			this->textBox16->Location = System::Drawing::Point(123, 91);
			this->textBox16->MaxLength = 1;
			this->textBox16->Name = L"textBox16";
			this->textBox16->Size = System::Drawing::Size(31, 20);
			this->textBox16->TabIndex = 16;
			this->textBox16->TextAlign = System::Windows::Forms::HorizontalAlignment::Center;
			// 
			// textBox15
			// 
			this->textBox15->Location = System::Drawing::Point(86, 91);
			this->textBox15->MaxLength = 1;
			this->textBox15->Name = L"textBox15";
			this->textBox15->Size = System::Drawing::Size(31, 20);
			this->textBox15->TabIndex = 15;
			this->textBox15->TextAlign = System::Windows::Forms::HorizontalAlignment::Center;
			// 
			// textBox14
			// 
			this->textBox14->Location = System::Drawing::Point(49, 91);
			this->textBox14->MaxLength = 1;
			this->textBox14->Name = L"textBox14";
			this->textBox14->Size = System::Drawing::Size(31, 20);
			this->textBox14->TabIndex = 14;
			this->textBox14->TextAlign = System::Windows::Forms::HorizontalAlignment::Center;
			// 
			// textBox13
			// 
			this->textBox13->Location = System::Drawing::Point(12, 91);
			this->textBox13->MaxLength = 1;
			this->textBox13->Name = L"textBox13";
			this->textBox13->Size = System::Drawing::Size(31, 20);
			this->textBox13->TabIndex = 13;
			this->textBox13->TextAlign = System::Windows::Forms::HorizontalAlignment::Center;
			// 
			// textBox12
			// 
			this->textBox12->Location = System::Drawing::Point(123, 65);
			this->textBox12->MaxLength = 1;
			this->textBox12->Name = L"textBox12";
			this->textBox12->Size = System::Drawing::Size(31, 20);
			this->textBox12->TabIndex = 12;
			this->textBox12->TextAlign = System::Windows::Forms::HorizontalAlignment::Center;
			// 
			// textBox11
			// 
			this->textBox11->Location = System::Drawing::Point(86, 65);
			this->textBox11->MaxLength = 1;
			this->textBox11->Name = L"textBox11";
			this->textBox11->Size = System::Drawing::Size(31, 20);
			this->textBox11->TabIndex = 11;
			this->textBox11->TextAlign = System::Windows::Forms::HorizontalAlignment::Center;
			// 
			// textBox10
			// 
			this->textBox10->Location = System::Drawing::Point(49, 65);
			this->textBox10->MaxLength = 1;
			this->textBox10->Name = L"textBox10";
			this->textBox10->Size = System::Drawing::Size(31, 20);
			this->textBox10->TabIndex = 10;
			this->textBox10->TextAlign = System::Windows::Forms::HorizontalAlignment::Center;
			// 
			// textBox9
			// 
			this->textBox9->Location = System::Drawing::Point(12, 65);
			this->textBox9->MaxLength = 1;
			this->textBox9->Name = L"textBox9";
			this->textBox9->Size = System::Drawing::Size(31, 20);
			this->textBox9->TabIndex = 9;
			this->textBox9->TextAlign = System::Windows::Forms::HorizontalAlignment::Center;
			// 
			// textBox8
			// 
			this->textBox8->Location = System::Drawing::Point(123, 39);
			this->textBox8->MaxLength = 1;
			this->textBox8->Name = L"textBox8";
			this->textBox8->Size = System::Drawing::Size(31, 20);
			this->textBox8->TabIndex = 8;
			this->textBox8->TextAlign = System::Windows::Forms::HorizontalAlignment::Center;
			// 
			// textBox7
			// 
			this->textBox7->Location = System::Drawing::Point(86, 39);
			this->textBox7->MaxLength = 1;
			this->textBox7->Name = L"textBox7";
			this->textBox7->Size = System::Drawing::Size(31, 20);
			this->textBox7->TabIndex = 7;
			this->textBox7->TextAlign = System::Windows::Forms::HorizontalAlignment::Center;
			// 
			// textBox6
			// 
			this->textBox6->Location = System::Drawing::Point(49, 39);
			this->textBox6->MaxLength = 1;
			this->textBox6->Name = L"textBox6";
			this->textBox6->Size = System::Drawing::Size(31, 20);
			this->textBox6->TabIndex = 6;
			this->textBox6->TextAlign = System::Windows::Forms::HorizontalAlignment::Center;
			// 
			// textBox5
			// 
			this->textBox5->Location = System::Drawing::Point(12, 39);
			this->textBox5->MaxLength = 1;
			this->textBox5->Name = L"textBox5";
			this->textBox5->Size = System::Drawing::Size(31, 20);
			this->textBox5->TabIndex = 5;
			this->textBox5->TextAlign = System::Windows::Forms::HorizontalAlignment::Center;
			// 
			// textBox4
			// 
			this->textBox4->Location = System::Drawing::Point(123, 13);
			this->textBox4->MaxLength = 1;
			this->textBox4->Name = L"textBox4";
			this->textBox4->Size = System::Drawing::Size(31, 20);
			this->textBox4->TabIndex = 4;
			this->textBox4->TextAlign = System::Windows::Forms::HorizontalAlignment::Center;
			// 
			// textBox3
			// 
			this->textBox3->Location = System::Drawing::Point(86, 13);
			this->textBox3->MaxLength = 1;
			this->textBox3->Name = L"textBox3";
			this->textBox3->Size = System::Drawing::Size(31, 20);
			this->textBox3->TabIndex = 3;
			this->textBox3->TextAlign = System::Windows::Forms::HorizontalAlignment::Center;
			// 
			// textBox2
			// 
			this->textBox2->Location = System::Drawing::Point(49, 13);
			this->textBox2->MaxLength = 1;
			this->textBox2->Name = L"textBox2";
			this->textBox2->Size = System::Drawing::Size(31, 20);
			this->textBox2->TabIndex = 2;
			this->textBox2->TextAlign = System::Windows::Forms::HorizontalAlignment::Center;
			// 
			// textBox1
			// 
			this->textBox1->Location = System::Drawing::Point(12, 13);
			this->textBox1->MaxLength = 1;
			this->textBox1->Name = L"textBox1";
			this->textBox1->Size = System::Drawing::Size(31, 20);
			this->textBox1->TabIndex = 1;
			this->textBox1->TextAlign = System::Windows::Forms::HorizontalAlignment::Center;
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Location = System::Drawing::Point(41, 74);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(144, 13);
			this->label1->TabIndex = 1;
			this->label1->Text = L"Input the Wordament Board :";
			// 
			// label2
			// 
			this->label2->AutoSize = true;
			this->label2->Location = System::Drawing::Point(252, 148);
			this->label2->Name = L"label2";
			this->label2->Size = System::Drawing::Size(71, 13);
			this->label2->TabIndex = 2;
			this->label2->Text = L"Total Score : ";
			// 
			// label3
			// 
			this->label3->AutoSize = true;
			this->label3->Location = System::Drawing::Point(252, 128);
			this->label3->Name = L"label3";
			this->label3->Size = System::Drawing::Size(80, 13);
			this->label3->TabIndex = 3;
			this->label3->Text = L"Words Found : ";
			// 
			// label4
			// 
			this->label4->AutoSize = true;
			this->label4->Location = System::Drawing::Point(252, 167);
			this->label4->Name = L"label4";
			this->label4->Size = System::Drawing::Size(92, 13);
			this->label4->TabIndex = 4;
			this->label4->Text = L"Remaining Time : ";
			// 
			// wordsfound
			// 
			this->wordsfound->AutoSize = true;
			this->wordsfound->Location = System::Drawing::Point(389, 128);
			this->wordsfound->Name = L"wordsfound";
			this->wordsfound->Size = System::Drawing::Size(10, 13);
			this->wordsfound->TabIndex = 5;
			this->wordsfound->Text = L"-";
			// 
			// score
			// 
			this->score->AutoSize = true;
			this->score->Location = System::Drawing::Point(389, 148);
			this->score->Name = L"score";
			this->score->Size = System::Drawing::Size(10, 13);
			this->score->TabIndex = 6;
			this->score->Text = L"-";
			// 
			// remainingtime
			// 
			this->remainingtime->AutoSize = true;
			this->remainingtime->Location = System::Drawing::Point(389, 167);
			this->remainingtime->Name = L"remainingtime";
			this->remainingtime->Size = System::Drawing::Size(10, 13);
			this->remainingtime->TabIndex = 7;
			this->remainingtime->Text = L"-";
			// 
			// solve
			// 
			this->solve->Location = System::Drawing::Point(225, 207);
			this->solve->Name = L"solve";
			this->solve->Size = System::Drawing::Size(75, 23);
			this->solve->TabIndex = 8;
			this->solve->Text = L"Solve";
			this->solve->UseVisualStyleBackColor = true;
			this->solve->Click += gcnew System::EventHandler(this, &MyForm::solve_Click);
			// 
			// clearButton
			// 
			this->clearButton->Location = System::Drawing::Point(306, 207);
			this->clearButton->Name = L"clearButton";
			this->clearButton->Size = System::Drawing::Size(75, 23);
			this->clearButton->TabIndex = 9;
			this->clearButton->Text = L"Clear";
			this->clearButton->UseVisualStyleBackColor = true;
			this->clearButton->Click += gcnew System::EventHandler(this, &MyForm::clearButton_Click);
			// 
			// label5
			// 
			this->label5->AutoSize = true;
			this->label5->Font = (gcnew System::Drawing::Font(L"Segoe Print", 11.25F, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->label5->Location = System::Drawing::Point(295, 83);
			this->label5->Name = L"label5";
			this->label5->Size = System::Drawing::Size(90, 26);
			this->label5->TabIndex = 11;
			this->label5->Text = L"Statistics :";
			// 
			// button1
			// 
			this->button1->Location = System::Drawing::Point(436, 207);
			this->button1->Name = L"button1";
			this->button1->Size = System::Drawing::Size(75, 23);
			this->button1->TabIndex = 12;
			this->button1->Text = L"Exit";
			this->button1->UseVisualStyleBackColor = true;
			this->button1->Click += gcnew System::EventHandler(this, &MyForm::button1_Click);
			// 
			// listView1
			// 
			this->listView1->Columns->AddRange(gcnew cli::array< System::Windows::Forms::ColumnHeader^  >(2) { this->columnHeader1, this->columnHeader2 });
			this->listView1->Items->AddRange(gcnew cli::array< System::Windows::Forms::ListViewItem^  >(2) { listViewItem1, listViewItem2 });
			this->listView1->Location = System::Drawing::Point(22, 284);
			this->listView1->Name = L"listView1";
			this->listView1->Size = System::Drawing::Size(502, 201);
			this->listView1->TabIndex = 13;
			this->listView1->UseCompatibleStateImageBehavior = false;
			this->listView1->View = System::Windows::Forms::View::Details;
			// 
			// columnHeader1
			// 
			this->columnHeader1->Text = L"Words";
			this->columnHeader1->Width = 249;
			// 
			// columnHeader2
			// 
			this->columnHeader2->Text = L"Score";
			this->columnHeader2->Width = 251;
			// 
			// label6
			// 
			this->label6->AutoSize = true;
			this->label6->Font = (gcnew System::Drawing::Font(L"Microsoft YaHei", 15.75F, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->label6->ForeColor = System::Drawing::SystemColors::HotTrack;
			this->label6->Location = System::Drawing::Point(75, 24);
			this->label6->Name = L"label6";
			this->label6->Size = System::Drawing::Size(242, 28);
			this->label6->TabIndex = 14;
			this->label6->Text = L"- Wordament Solver -";
			// 
			// menuStrip1
			// 
			this->menuStrip1->Items->AddRange(gcnew cli::array< System::Windows::Forms::ToolStripItem^  >(2) {
				this->fileToolStripMenuItem,
					this->aboutToolStripMenuItem
			});
			this->menuStrip1->Location = System::Drawing::Point(0, 0);
			this->menuStrip1->Name = L"menuStrip1";
			this->menuStrip1->Size = System::Drawing::Size(547, 24);
			this->menuStrip1->TabIndex = 15;
			this->menuStrip1->Text = L"menuStrip1";
			// 
			// fileToolStripMenuItem
			// 
			this->fileToolStripMenuItem->DropDownItems->AddRange(gcnew cli::array< System::Windows::Forms::ToolStripItem^  >(3) {
				this->solveToolStripMenuItem,
					this->clearToolStripMenuItem, this->exitToolStripMenuItem
			});
			this->fileToolStripMenuItem->Name = L"fileToolStripMenuItem";
			this->fileToolStripMenuItem->Size = System::Drawing::Size(37, 20);
			this->fileToolStripMenuItem->Text = L"File";
			// 
			// solveToolStripMenuItem
			// 
			this->solveToolStripMenuItem->Name = L"solveToolStripMenuItem";
			this->solveToolStripMenuItem->Size = System::Drawing::Size(102, 22);
			this->solveToolStripMenuItem->Text = L"Solve";
			this->solveToolStripMenuItem->Click += gcnew System::EventHandler(this, &MyForm::solveToolStripMenuItem_Click);
			// 
			// clearToolStripMenuItem
			// 
			this->clearToolStripMenuItem->Name = L"clearToolStripMenuItem";
			this->clearToolStripMenuItem->Size = System::Drawing::Size(102, 22);
			this->clearToolStripMenuItem->Text = L"Clear";
			this->clearToolStripMenuItem->Click += gcnew System::EventHandler(this, &MyForm::clearToolStripMenuItem_Click);
			// 
			// exitToolStripMenuItem
			// 
			this->exitToolStripMenuItem->Name = L"exitToolStripMenuItem";
			this->exitToolStripMenuItem->Size = System::Drawing::Size(102, 22);
			this->exitToolStripMenuItem->Text = L"Exit";
			this->exitToolStripMenuItem->Click += gcnew System::EventHandler(this, &MyForm::exitToolStripMenuItem_Click);
			// 
			// aboutToolStripMenuItem
			// 
			this->aboutToolStripMenuItem->DropDownItems->AddRange(gcnew cli::array< System::Windows::Forms::ToolStripItem^  >(2) {
				this->helpToolStripMenuItem,
					this->aboutToolStripMenuItem1
			});
			this->aboutToolStripMenuItem->Name = L"aboutToolStripMenuItem";
			this->aboutToolStripMenuItem->Size = System::Drawing::Size(52, 20);
			this->aboutToolStripMenuItem->Text = L"About";
			// 
			// helpToolStripMenuItem
			// 
			this->helpToolStripMenuItem->Name = L"helpToolStripMenuItem";
			this->helpToolStripMenuItem->Size = System::Drawing::Size(107, 22);
			this->helpToolStripMenuItem->Text = L"Help";
			this->helpToolStripMenuItem->Click += gcnew System::EventHandler(this, &MyForm::helpToolStripMenuItem_Click);
			// 
			// aboutToolStripMenuItem1
			// 
			this->aboutToolStripMenuItem1->Name = L"aboutToolStripMenuItem1";
			this->aboutToolStripMenuItem1->Size = System::Drawing::Size(107, 22);
			this->aboutToolStripMenuItem1->Text = L"About";
			this->aboutToolStripMenuItem1->Click += gcnew System::EventHandler(this, &MyForm::aboutToolStripMenuItem1_Click);
			// 
			// progressBar1
			// 
			this->progressBar1->Location = System::Drawing::Point(22, 246);
			this->progressBar1->Name = L"progressBar1";
			this->progressBar1->Size = System::Drawing::Size(502, 23);
			this->progressBar1->Style = System::Windows::Forms::ProgressBarStyle::Continuous;
			this->progressBar1->TabIndex = 16;
			// 
			// label7
			// 
			this->label7->AutoSize = true;
			this->label7->Font = (gcnew System::Drawing::Font(L"Microsoft YaHei", 12, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(134)));
			this->label7->Location = System::Drawing::Point(388, 29);
			this->label7->Name = L"label7";
			this->label7->Size = System::Drawing::Size(131, 22);
			this->label7->TabIndex = 17;
			this->label7->Text = L"Time Left : 120";
			// 
			// backgroundWorker1
			// 
			this->backgroundWorker1->WorkerReportsProgress = true;
			this->backgroundWorker1->DoWork += gcnew System::ComponentModel::DoWorkEventHandler(this, &MyForm::backgroundWorker1_DoWork);
			this->backgroundWorker1->ProgressChanged += gcnew System::ComponentModel::ProgressChangedEventHandler(this, &MyForm::backgroundWorker1_ProgressChanged);
			this->backgroundWorker1->RunWorkerCompleted += gcnew System::ComponentModel::RunWorkerCompletedEventHandler(this, &MyForm::backgroundWorker1_RunWorkerCompleted);
			// 
			// timer1
			// 
			this->timer1->Interval = 1000;
			this->timer1->Tick += gcnew System::EventHandler(this, &MyForm::timer1_Tick);
			// 
			// MyForm
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->ClientSize = System::Drawing::Size(547, 497);
			this->Controls->Add(this->label7);
			this->Controls->Add(this->progressBar1);
			this->Controls->Add(this->label6);
			this->Controls->Add(this->listView1);
			this->Controls->Add(this->button1);
			this->Controls->Add(this->label5);
			this->Controls->Add(this->clearButton);
			this->Controls->Add(this->solve);
			this->Controls->Add(this->remainingtime);
			this->Controls->Add(this->score);
			this->Controls->Add(this->wordsfound);
			this->Controls->Add(this->label4);
			this->Controls->Add(this->label3);
			this->Controls->Add(this->label2);
			this->Controls->Add(this->label1);
			this->Controls->Add(this->panel1);
			this->Controls->Add(this->menuStrip1);
			this->MainMenuStrip = this->menuStrip1;
			this->Name = L"MyForm";
			this->Text = L"Wordament Solver";
			this->panel1->ResumeLayout(false);
			this->panel1->PerformLayout();
			this->menuStrip1->ResumeLayout(false);
			this->menuStrip1->PerformLayout();
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
	private: System::Void initMatriks(char** board) {
		board[0][0] = tolower(System::Convert::ToChar(textBox1->Text));
		board[0][1] = tolower(System::Convert::ToChar(textBox2->Text));
		board[0][2] = tolower(System::Convert::ToChar(textBox3->Text));
		board[0][3] = tolower(System::Convert::ToChar(textBox4->Text));
		board[1][0] = tolower(System::Convert::ToChar(textBox5->Text));
		board[1][1] = tolower(System::Convert::ToChar(textBox6->Text));
		board[1][2] = tolower(System::Convert::ToChar(textBox7->Text));
		board[1][3] = tolower(System::Convert::ToChar(textBox8->Text));
		board[2][0] = tolower(System::Convert::ToChar(textBox9->Text));
		board[2][1] = tolower(System::Convert::ToChar(textBox10->Text));
		board[2][2] = tolower(System::Convert::ToChar(textBox11->Text));
		board[2][3] = tolower(System::Convert::ToChar(textBox12->Text));
		board[3][0] = tolower(System::Convert::ToChar(textBox13->Text));
		board[3][1] = tolower(System::Convert::ToChar(textBox14->Text));
		board[3][2] = tolower(System::Convert::ToChar(textBox15->Text));
		board[3][3] = tolower(System::Convert::ToChar(textBox16->Text));
	}

	private: System::Void loadDictionary(vector<string>& tab_words) {
		string line;
		ifstream myfile("dictionary.txt");
		if (myfile.is_open())
		{
			while (getline(myfile, line))
			{
				tab_words.push_back(line);
			}
			myfile.close();
		}
	}

	bool isBoardValid() {
		if (textBox1->Text->Length==0 || textBox2->Text->Length==0 || textBox3->Text->Length==0 || textBox4->Text->Length==0
			|| textBox5->Text->Length==0 || textBox6->Text->Length==0 || textBox7->Text->Length==0 || textBox8->Text->Length==0
			|| textBox9->Text->Length==0 || textBox10->Text->Length==0 || textBox11->Text->Length==0 || textBox12->Text->Length==0
			|| textBox13->Text->Length==0 || textBox14->Text->Length==0 || textBox15->Text->Length==0 || textBox16->Text->Length==0) {
			return false;
		}	
		else {
			return true;
		}
	}

	private: System::Void solve_Click(System::Object^  sender, System::EventArgs^  e) {
		if (isBoardValid()) {
			timer1->Enabled = true;
			clearButton->Enabled = false;
			clearToolStripMenuItem->Enabled = false;
			exitToolStripMenuItem->Enabled = false;
			button1->Enabled = false;
			solve->Enabled = false;
			solveToolStripMenuItem->Enabled = false;
			backgroundWorker1->RunWorkerAsync();
		}
		else {
			MessageBox::Show("Please fill the whole board");
		}
	}

	private: System::Void button1_Click(System::Object^  sender, System::EventArgs^  e) {
		Application::Exit();
	}

	bool findmatch(char** board, string pat, int x, int y, int level)
	{
		if (level == pat.length()) //pattern matched
			return true;

		if (x<0 || y<0 || x >= 4 || y >= 4)
			return false;

		if (board[x][y] == pat[level])
		{
			bool res;

			//marking this cell as used so it doesn't give a "true"
			char temp = board[x][y];
			board[x][y] = '#';

			//finding next char pattern in 8 neighbours     
			res = findmatch(board, pat, x - 1, y, level + 1) ||
				findmatch(board, pat, x + 1, y, level + 1) ||
				findmatch(board, pat, x, y - 1, level + 1) ||
				findmatch(board, pat, x, y + 1, level + 1) ||
				findmatch(board, pat, x + 1, y + 1, level + 1) ||
				findmatch(board, pat, x + 1, y - 1, level + 1) ||
				findmatch(board, pat, x - 1, y + 1, level + 1) ||
				findmatch(board, pat, x - 1, y - 1, level + 1);

			//marking this cell as unused
			board[x][y] = temp;
			return res;
		}
		else
			return false;
	}

	bool isfind(char** board, string pat)
	{
		// if total characters in matrix is less than pattern length
		if (pat.length() > 16)
			return false;

		for (int i = 0; i<4; i++) {
			for (int j = 0; j<4; j++) {

				if (board[i][j] == pat[0])
					if (findmatch(board, pat, i, j, 0))
						return true;
			}
		}
		return false;
	}

	private: System::Void clearButton_Click(System::Object^  sender, System::EventArgs^  e) {
		wordsfound->Text = "-";
		score->Text = "-";
		remainingtime->Text = "-";		
		second = 120;
		label7->Text = "Time Left : " + System::Convert::ToString(second);
		listView1->Items->Clear();
		finished = false;
		timer1->Enabled = false;
		progressBar1->Value = 0;
		while (!temp.empty()) {
			temp.pop_back();
		}
		scores = 0;
		word_found = 0;
		count = 0;
		textBox1->Clear();			textBox5->Clear();
		textBox2->Clear();			textBox6->Clear();
		textBox3->Clear();			textBox7->Clear();
		textBox4->Clear();			textBox8->Clear();
		
		textBox9->Clear();			textBox13->Clear();
		textBox10->Clear();			textBox14->Clear();
		textBox11->Clear();			textBox15->Clear();
		textBox12->Clear();			textBox16->Clear();
			
	}

	// menu strip code 
	private: System::Void solveToolStripMenuItem_Click(System::Object^  sender, System::EventArgs^  e) {
		if (isBoardValid()) {
			timer1->Enabled = true;
			clearButton->Enabled = false;
			clearToolStripMenuItem->Enabled = false;
			exitToolStripMenuItem->Enabled = false;
			button1->Enabled = false;
			solve->Enabled = false;
			solveToolStripMenuItem->Enabled = false;
			backgroundWorker1->RunWorkerAsync();
		}
		else {
			MessageBox::Show("Please fill the whole board");
		}
	}

	private: System::Void clearToolStripMenuItem_Click(System::Object^  sender, System::EventArgs^  e) {
		wordsfound->Text = "-";
		score->Text = "-";
		remainingtime->Text = "-";
		second = 120;
		label7->Text = "Time Left : " + System::Convert::ToString(second);
		listView1->Items->Clear();
		finished = false;
		timer1->Enabled = false;
		progressBar1->Value = 0;
		while (!temp.empty()) {
			temp.pop_back();
		}
		scores = 0;
		word_found = 0;
		count = 0;
		textBox1->Clear();			textBox5->Clear();
		textBox2->Clear();			textBox6->Clear();
		textBox3->Clear();			textBox7->Clear();
		textBox4->Clear();			textBox8->Clear();

		textBox9->Clear();			textBox13->Clear();
		textBox10->Clear();			textBox14->Clear();
		textBox11->Clear();			textBox15->Clear();
		textBox12->Clear();			textBox16->Clear();
	}

	private: System::Void exitToolStripMenuItem_Click(System::Object^  sender, System::EventArgs^  e) {
		Application::Exit();
	}
	
	// about and help code
	private: System::Void helpToolStripMenuItem_Click(System::Object^  sender, System::EventArgs^  e) {
		MessageBox::Show("Wordament Solver by Varian Caesar\n\nFill the board and click solve to start the program\nUse clear button to clear the board and the results\n\nenjoy then ^-^");
	}

	private: System::Void aboutToolStripMenuItem1_Click(System::Object^  sender, System::EventArgs^  e) {
		MessageBox::Show("Wordament Solver created by Varian Caesar / 13514041\nif you find any trouble or bug please contact : variancaesar@gmail.com ^-^");
	}

	// multithreading code for solver 
	private: System::Void backgroundWorker1_DoWork(System::Object^  sender, System::ComponentModel::DoWorkEventArgs^  e) {
		char** board;
		board = new char*[4];
		vector<string> tab_words;
		for (int i = 0; i < 4; i++) {
			board[i] = new char[4];
		}
		initMatriks(board);
		loadDictionary(tab_words);
		int progress = 10;
		backgroundWorker1->ReportProgress(progress);
		// solving process
		for (string pat : tab_words) {
			if (second == 0)
				break;

			if (isfind(board, pat)) {
				count++;
				if (count % 4 == 0) {
					progress++;
					backgroundWorker1->ReportProgress(progress);
				}
				scores += pat.length();
				word_found++;
				temp.push_back(pat);
			}
		}
		
	}

	private: System::Void backgroundWorker1_RunWorkerCompleted(System::Object^  sender, System::ComponentModel::RunWorkerCompletedEventArgs^  e) {
		// show the words found
		for (string v : temp) {
			String^ str3 = gcnew String(v.c_str());
			ListViewItem^ newitem = gcnew ListViewItem(str3);
			newitem->SubItems->Add(System::Convert::ToString(v.length()));
			listView1->Items->Add(newitem);
		}

		// statistics
		progressBar1->Value = 100;
		finished = true;
		MessageBox::Show("Program Finished");
		wordsfound->Text = System::Convert::ToString(word_found);
		score->Text = System::Convert::ToString(scores);
		remainingtime->Text = System::Convert::ToString(second);

		// enabled all button
		clearButton->Enabled = true;
		clearToolStripMenuItem->Enabled = true;
		exitToolStripMenuItem->Enabled = true;
		button1->Enabled = true;
		solve->Enabled = true;
		solveToolStripMenuItem->Enabled = true;
	}

	private: System::Void backgroundWorker1_ProgressChanged(System::Object^  sender, System::ComponentModel::ProgressChangedEventArgs^  e) {
		progressBar1->Value = e->ProgressPercentage;
	}
	
	// UI Threading for timer
	private: System::Void timer1_Tick(System::Object^  sender, System::EventArgs^  e) {
		if(!finished && second > 0) {
			second--;
		}
		label7->Text = "Time Left : " + System::Convert::ToString(second);
	}
};
}
