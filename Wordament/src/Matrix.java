/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawordament;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Johan
 */
public class Matrix {
    private char[][] data = new char [4][4];
	
    public Matrix(){
            for (int i=0; i<4; i++){
                    for (int j=0; j<4; j++){
                            data[i][j]=' ';
                    }
            }
    }

    public char GetChar(Cell P){
            return data[P.x][P.y];
    }

    public void SetChar(Cell P, char c){
            data[P.y][P.x] = Character.toUpperCase(c);
    }

    public String toString() {
            StringBuilder res = new StringBuilder();
            for(int i=0; i<4; i++) {
                res.append(Arrays.toString(data[i]));
                res.append("\n");
            }
            res.append("\n");
            return res.toString();
    }
}
