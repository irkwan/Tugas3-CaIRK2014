package com.company;

import res.Wordament;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Timer;
import java.util.TimerTask;
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
    private JList listAnswer;
    private JScrollPane scrollPane;
    private JLabel scoreLabel;
    private JButton clearButton;
    private JButton aboutButton;
    private JButton howToPlayButton;
    private boolean solve_done;
    private Timer timer;

    private char[][] matrix;

    private int remainingSeconds;
    private final int firstMiliSeconds = 120000;
    /** Public Methods **/

    /** Timer **/
    public void displayTimer() {
        timerLabel.setText(String.format("Time Remaining: %d ms", remainingSeconds));
    }

    private void initTimer(){
        remainingSeconds = firstMiliSeconds;
    }

    private void resetTimer() {
        initTimer();
        displayTimer();
    }

    /** Constructor **/
    public Solver() throws IOException {

        /** Initialize the frame **/
        JFrame frame = new JFrame("Solver");
        frame.setContentPane(wordamentsolverView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        matrix = new char[4][4];

        resetTimer();
        Wordament.Init();
        try {
            Wordament.InitDictionary();
        } catch (IOException e) {
            e.printStackTrace();
        }

        exitButton.addActionListener(new CloseListener());
        solveButton.addActionListener(new SolveListener());
        resetButton.addActionListener(new ResetListener());
        clearButton.addActionListener(new ClearListener());
        aboutButton.addActionListener(new AboutListener());
        howToPlayButton.addActionListener(new HowToPlayListener());
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

        private void Process(){
            /* Thread for process */
            Thread t1 = new Thread("Solve"){

                @Override
                public void run() {
                    generateCells();
                    Wordament.Solve(matrix);
                    ArrayList<String> res = Wordament.getRes();
                    DefaultListModel listModel = new DefaultListModel();
                    int totalScore = 0;
                    for (String s : res) {
                        listModel.addElement(s);
                        totalScore += s.length();
                    }
                    listAnswer.setModel(listModel);
                    scrollPane.createVerticalScrollBar();
                    solve_done = true;

                    scoreLabel.setText(String.format("Score: %d", totalScore));
                    String message = String.format("Wordament answer generated in %d ms!", firstMiliSeconds - remainingSeconds);
                    JOptionPane.showMessageDialog(wordamentsolverView, message, "Done", JOptionPane.INFORMATION_MESSAGE);
                }
            };
            t1.start();
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent){
            try {
                solve_done = false;
                checkField();
                resetTimer();

                timer = new Timer("timerSolve");
                timer.scheduleAtFixedRate(new TimerTask(){
                    @Override
                    public void run() {
                        if(remainingSeconds != 0 && !solve_done){
                            remainingSeconds--;
                        }
                        else {
                            timer.cancel();
                        }
                        displayTimer();
                    }
                }, 0, 1);

                Process();

            }
            catch(Exception e){
                String message = "Make sure that you have already fill every cell with exactly 1 (one) lowercase character ('a' - 'z')!";
                JOptionPane.showMessageDialog(wordamentsolverView, message, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }



    /** ResetListener for Reset Button **/
    private class ResetListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //timer.stop();
            resetTimer();
        }
    }

    /** ClearListener for Clear Button **/
    private class ClearListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            cell_00.setText("");
            cell_01.setText("");
            cell_02.setText("");
            cell_03.setText("");

            cell_10.setText("");
            cell_11.setText("");
            cell_12.setText("");
            cell_13.setText("");

            cell_20.setText("");
            cell_21.setText("");
            cell_22.setText("");
            cell_23.setText("");

            cell_30.setText("");
            cell_31.setText("");
            cell_32.setText("");
            cell_33.setText("");
        }
    }

    /** AboutListener for About Button **/
    private class AboutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JOptionPane.showMessageDialog(wordamentsolverView, "Wordament Solver 1.0.0\nBy: Alfonsus Raditya Arsadjaja\nNIM: 13514088", "About", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class HowToPlayListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String message = "1. Fill every cell with a lowercase character ('a' to 'z')\n" +
                    "2. Don't leave every cell with blank, or more than 1 character\n" +
                    "3. Click Solve to generate the answer\n\n\n" +
                    "\n" +
                    "\n" +
                    "Additional:\n" +
                    "Click Reset to reset the time\n" +
                    "Click About to see the credits\n" +
                    "Click Clear to clear the cells\n\n\n" +
                    "Enjoy the game!";
            JOptionPane.showMessageDialog(wordamentsolverView, message, "How To Play", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

/* Timernya belum 100% jalan dengan displayTimer() */