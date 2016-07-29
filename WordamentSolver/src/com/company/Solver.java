package com.company;

import res.Wordament;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by raditya on 7/19/16.
 */

public class Solver {

    /** Private Methods **/
    private JButton solveButton;
    private JButton resetButton;
    private JButton exitButton;
    private JPanel wordamentsolverView;
    private JLabel timerLabel;
    private JTextField cell_00;
    private JTextField cell_01;
    private JTextField cell_02;
    private JTextField cell_03;
    private JTextField cell_10;
    private JTextField cell_11;
    private JTextField cell_12;
    private JTextField cell_13;
    private JTextField cell_20;
    private JTextField cell_21;
    private JTextField cell_22;
    private JTextField cell_23;
    private JTextField cell_30;
    private JTextField cell_31;
    private JTextField cell_32;
    private JTextField cell_33;
    private double remainingSeconds;
    private Timer timer;
    private final int delay = 10;
    private final double firstSeconds = 120;

    /** Public Methods **/

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
    /** Listener **/

    /** TimerListener for Timer Countdown **/
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

    /** CloseListener for Exit Button **/
    private class CloseListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.exit(0);
        }
    }

    /** SolveListener for Solve Button **/
    private class SolveListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent){
            resetTimer();
            timer.start();
        }
    }

    /** ResetListener for Reset Button **/
    private class ResetListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            timer.stop();
            resetTimer();
        }
    }

    /** Constructor **/
    public Solver() throws IOException {
        Wordament.Init();
        Wordament.InitDictionary();
        resetTimer();

        timer = new Timer(delay, new TimerListener());

        exitButton.addActionListener(new CloseListener());
        solveButton.addActionListener(new SolveListener());
        resetButton.addActionListener(new ResetListener());
    }



    /** To make it can be called from Main Program **/
    public JPanel callView() {
        return wordamentsolverView;
    }

}

