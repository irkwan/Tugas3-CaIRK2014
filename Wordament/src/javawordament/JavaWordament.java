/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawordament;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Johan
 */
public class JavaWordament {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        Dictionary D = new Dictionary();
        boolean B = D.scanWordFile("E:\\documents\\IRK\\dict.txt");
        Scanner in = new Scanner (new File ("E:\\documents\\IRK\\matriks.txt"));
        
        Matrix M = new Matrix();
        int i,j; char n;
        for (i=0; i<4; i++)
            {
                for (j=0; j<4; j++)
                {
                    n =  in.next().charAt(0);
                        M.SetChar(new Cell(j,i), n);
                    
                }
            }
        
        GameTree T = new GameTree(M,D);
        T.Begin();
        Vector<Status> temp = T.getResult();

        System.out.print(M);
        System.out.print(temp);
    }
    
}
