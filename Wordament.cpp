#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <locale>
using namespace std;

// global variable
vector<string> tab_word;
char board[4][4];

void loadDictionary(){
	ifstream dict("dictionary.txt");
	string temp;
	
	if(dict.is_open()) {
		while(getline(dict,temp)){
			tab_word.push_back(temp);
		}
		dict.close();
	}
}

void initBoard(){
	for(int i = 0; i < 4; i++){
		for(int j = 0; j < 4; j++){
			cin >> board[i][j];
			board[i][j] = tolower(board[i][j]);
		}
	}
}

void printBoard(){
	for(int i = 0; i < 4; i++){
		for(int j = 0; j < 4; j++){
			cout << board[i][j] << " ";
		}
		cout << endl;
	}
}

int main() {
	loadDictionary();
	initBoard();
	printBoard();
	return 0;
}
