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
        Dictionary D = new Dictionary();
        boolean B = D.scanWordFile("dict.txt");
        Scanner sc = new Scanner (new File ("matriks.txt"));
        
        Matrix M = new Matrix();
        int i,j; char n;
        for (i=0; i<4; i++)
            {
                for (j=0; j<4; j++)
                {
                    n =  sc.next().charAt(0);
                        M.SetChar(new Cell(j,i), n);
                    
                }
            }
        
        long start = System.nanoTime();
        Tree T = new Tree(M,D);
        T.begin();
        Vector<Status> temp = T.getResult();

        System.out.print(M);
        System.out.print(temp);
        
        long end = System.nanoTime();
        long duration = (end-start)/1000000;
        
        System.out.println("Waktu Eksekusi " + duration + " ms");
    }
    
}
