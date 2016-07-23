/*
Author  : Varian Caesar
NIM	    : 13514041
Program : Wordament solver

This program created for IRK recruitment process
*/

#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <locale>
using namespace std;

void loadDictionary(vector<string>& tab_words){
	ifstream dict("dictionary.txt");
	string temp;
	
	if(dict.is_open()) {
		while(getline(dict,temp)){
			tab_words.push_back(temp);
		}
		dict.close();
	}
}

void initBoard(char** board){
	for(int i = 0; i < 4; i++){
		for(int j = 0; j < 4; j++){
			cin >> board[i][j];
			board[i][j] = tolower(board[i][j]);
		}
	}
}

void printBoard(char** board){
	for(int i = 0; i < 4; i++){
		for(int j = 0; j < 4; j++){
			cout << board[i][j] << " ";
		}
		cout << endl;
	}
}

bool findmatch(char** board,string pat, int x, int y, int level)
{
    if (level == pat.length()) //pattern matched
        return true;
        
    if (x<0 || y<0 || x>=4 || y>=4)
     return false; 
    
    if (board[x][y] == pat[level])
    {
        bool res;

        //marking this cell as used
        //if not found, then we continue searching from this location
        char temp = board[x][y];
        board[x][y] = '#';       
             
        //finding next char pattern in 8 neighbours     
        res = findmatch(board,pat, x-1, y,level+1)   ||
              findmatch(board,pat, x+1, y,level+1)   ||
              findmatch(board,pat, x, y-1,level+1)   ||
              findmatch(board,pat, x, y+1,level+1)   ||
              findmatch(board,pat, x+1, y+1,level+1) ||
              findmatch(board,pat, x+1, y-1,level+1) ||
              findmatch(board,pat, x-1, y+1,level+1) ||
              findmatch(board,pat, x-1, y-1,level+1);

        //marking this cell as unused
        board[x][y] = temp;
        return res;
    }
    else
        return false;
}

bool isfind(char** board,string pat)
{
 // if total characters in matrix is less then pattern lenghth
    if (pat.length() > 16)
        return false;

    for (int i=0; i<4; i++) {
    	for (int j=0; j<4; j++){

      		if (board[i][j] == pat[0])
                    if(findmatch(board,pat, i, j, 0)) 
                          return true;
     	}
     }
    return false;
}

int main() {
	char** board = new char*[4];
	for(int i = 0; i < 4; i++){
		board[i] = new char[4];
	}
	vector<string> tab_words;
	
	loadDictionary(tab_words);
	initBoard(board);
	int score = 0, word_found = 0;
	
	for(string pat : tab_words){
		if(isfind(board,pat)){
			cout << pat << "  " << pat.length() << endl;
			score += pat.length();
			word_found++;
		}
	}
	cout << "Total words found : " << word_found << endl;
	cout << "Total Score : " << score << endl;
	return 0;
}
