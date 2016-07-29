package com.company;

import res.Wordament;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by raditya on 7/19/16.
 */

public class Solver {

    /** Private Methods **/
    private JButton solveButton;
    private JButton resetButton;
    private JButton exitButton;

    private JFrame frame;
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
    private JList listAnswer;

    private char[][] matrix;

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
            try {
                int totalScore = 0;
                checkField();
                generateCells();
                resetTimer();
                timer.start();

                Wordament.Solve(matrix);
                ArrayList<String> res = Wordament.getRes();
                DefaultListModel listModel = new DefaultListModel();

                for (String s : res) {
                    listModel.addElement(s);
                    System.out.println(s);
                    totalScore += s.length();
                }
                System.out.println(totalScore);
                listAnswer.setModel(listModel);

                frame.getContentPane().add(listAnswer);
            }
            catch(Exception e){

            }

        }
    }

    private void checkField() throws Exception {
        check(cell_00);
        check(cell_01);
        check(cell_02);
        check(cell_03);
        check(cell_10);
        check(cell_11);
        check(cell_12);
        check(cell_13);
        check(cell_20);
        check(cell_21);
        check(cell_22);
        check(cell_23);
        check(cell_30);
        check(cell_31);
        check(cell_32);
        check(cell_33);
    }

    private void check(JTextField cell) throws Exception {
        String S = cell.getText();
        if(S.length() != 1 || (S.charAt(0) < 'a' || S.charAt(0) > 'z')) throw new Exception();
    }

    private void generateCells() {
        matrix[0][0] = cell_00.getText().charAt(0);
        matrix[0][1] = cell_01.getText().charAt(0);
        matrix[0][2] = cell_02.getText().charAt(0);
        matrix[0][3] = cell_03.getText().charAt(0);

        matrix[1][0] = cell_10.getText().charAt(0);
        matrix[1][1] = cell_11.getText().charAt(0);
        matrix[1][2] = cell_12.getText().charAt(0);
        matrix[1][3] = cell_13.getText().charAt(0);

        matrix[2][0] = cell_20.getText().charAt(0);
        matrix[2][1] = cell_21.getText().charAt(0);
        matrix[2][2] = cell_22.getText().charAt(0);
        matrix[2][3] = cell_23.getText().charAt(0);

        matrix[3][0] = cell_30.getText().charAt(0);
        matrix[3][1] = cell_31.getText().charAt(0);
        matrix[3][2] = cell_32.getText().charAt(0);
        matrix[3][3] = cell_33.getText().charAt(0);
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

        /** Initialize the frame **/
        frame = new JFrame("Solver");
        frame.setContentPane(callView());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Wordament.Init();
        Wordament.InitDictionary();
        matrix = new char[4][4];
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

