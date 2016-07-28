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
    private JTable mainTable;
    private JLabel timerLabel;
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

        /**
        mainTable = new JTable(4,4);
        Color color = UIManager.getColor("Table.gridColor");
        MatteBorder border = new MatteBorder(1, 1, 0, 0, color);
        mainTable.setBorder(border);
         **/
    }

    /** To make it can be called from Main Program **/
    public JPanel callView() {
        return wordamentsolverView;
    }

}

