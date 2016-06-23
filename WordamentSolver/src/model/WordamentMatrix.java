package model;

import java.util.Arrays;

public class WordamentMatrix {
    
    private final char[][] data = new char[4][4];
    
    public WordamentMatrix() {
	for(int i=0; i<4; i++) 
	    for(int j=0; j<4; j++) 
		data[i][j] = 'A';
    }
    public WordamentMatrix(WordamentMatrix W) {
	for(int i=0; i<4; i++) System.arraycopy(W.data[i], 0, data[i], 0, 4);
    }
    
    public char getChar(Point P) {
	return data[P.y][P.x];
    }
    public void setChar(Point P, char c) {
	data[P.y][P.x] = c;
    }
    
    @Override
    public String toString() {
	StringBuilder res = new StringBuilder();
	for(int i=3; i>=0; i--) {
	    res.append(Arrays.toString(data[i]));
	    res.append("\n");
	}
	return res.toString();
    }
}
