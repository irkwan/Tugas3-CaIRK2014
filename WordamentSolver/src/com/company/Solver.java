package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by raditya on 7/19/16.
 */


public class Solver {

    private JButton solveButton;
    private JButton resetButton;
    private JButton exitButton;
    private JPanel wordamentsolverView;
    private JTable mainTable;
    private JLabel timerLabel;


    private class CloseListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public Solver() throws IOException {
        Wordament.Init();
        Wordament.InitDictionary();
        exitButton.addActionListener(new CloseListener());
    }


    public JPanel callView(){
        return wordamentsolverView;
    }
    /* kalo mau ngapa ngapain itu harus didalem kelasnya */


}

