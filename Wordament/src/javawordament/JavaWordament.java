/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawordament;

import java.util.Vector;

/**
 *
 * @author Johan
 */
public class JavaWordament {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Dictionary D = new Dictionary();
        boolean B = D.scanWordFile("E:\\documents\\IRK\\dict.txt");

        Matrix G = new Matrix();
        G.SetChar(new Cell(0,0), 'a');
        G.SetChar(new Cell(0,1), 'b');
        G.SetChar(new Cell(0,2), 'c');
        G.SetChar(new Cell(0,3), 'd');

        G.SetChar(new Cell(1,0), 'e');
        G.SetChar(new Cell(1,1), 'f');
        G.SetChar(new Cell(1,2), 'g');
        G.SetChar(new Cell(1,3), 'h');

        G.SetChar(new Cell(2,0), 'i');
        G.SetChar(new Cell(2,1), 'j');
        G.SetChar(new Cell(2,2), 'k');
        G.SetChar(new Cell(2,3), 'l');

        G.SetChar(new Cell(3,0), 'm');
        G.SetChar(new Cell(3,1), 'n');
        G.SetChar(new Cell(3,2), 'o');
        G.SetChar(new Cell(3,3), 'p');

        GameTree T = new GameTree(G,D);
        T.Begin();
        Vector<Status> temp = T.getResult();

        System.out.print(G);
        System.out.print(temp);
    }
    
}
