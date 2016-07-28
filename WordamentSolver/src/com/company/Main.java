package com.company;
import javax.swing.JFrame;
import java.io.IOException;

/**
 * Created by raditya on 7/19/16.
 */

public class Main {

    public static void main(String[] args) throws IOException {
	    /* write your code here */
        JFrame frame = new JFrame("Solver");
        frame.setContentPane(new Solver().callView());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
