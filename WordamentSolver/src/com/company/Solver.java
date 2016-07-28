package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
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
    private double remainingSeconds;
    private Timer timer;
    private final int delay = 10;
    private final double firstSeconds = 120;
    /* Ini masih belum pasti */

    /** Timer **/

    private void displayTimer(){
        timerLabel.setText(String.format("Time Remaining: %.2f second%s", remainingSeconds, (remainingSeconds != 1) ? "s" : ""));
    }
    private void initTimer(){
        remainingSeconds = firstSeconds;
    }
    private void resetTimer() {
        initTimer();
        displayTimer();
    }


    private class TimerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            remainingSeconds -= delay/1000.0;
            if(remainingSeconds <= 0){
                timer.stop();
            }
            displayTimer();
        }
    }

    private class CloseListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.exit(0);
        }
    }

    private class SolveListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent){
            resetTimer();
            timer.start();
        }
    }

    private class ResetListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            timer.stop();
            resetTimer();
        }
    }
    public Solver() throws IOException {
        Wordament.Init();
        Wordament.InitDictionary();
        resetTimer();
        timer = new Timer(delay, new TimerListener());
        exitButton.addActionListener(new CloseListener());
        solveButton.addActionListener(new SolveListener());
        resetButton.addActionListener(new ResetListener());


    }


    public JPanel callView(){
        return wordamentsolverView;
    }
    /* kalo mau ngapa ngapain itu harus didalem kelasnya */


}

