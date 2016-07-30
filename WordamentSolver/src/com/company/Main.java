package com.company;
import javax.swing.SwingUtilities;
import java.io.IOException;

/**
 * Created by raditya on 7/19/16.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Solver();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
