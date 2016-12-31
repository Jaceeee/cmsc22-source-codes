package lab.lab12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Juan Carlos on 10/28/2016.
 * main skeleton code taken from Nico Martin Enego's github page
 * https://github.com/nmenego/CMSC22SampleCodes/blob/master/src/gui/JSimpleCalculator.java
 */

public class Calculator extends JFrame {   // Jpanel instead of panel
    private static final int ADDITION = 1;
    private static final int SUBTRACTION = 2;
    private static final int MULTIPLICATION = 3;
    private static final int DIVISION = 4;

    private int opType;
    private BigDecimal number;
    private boolean pointChkr;

    private JLabel lblSum;

    private JButton clear;
    private JButton sign;
    private JButton percent;
    private JButton divide;
    private JButton multiply;
    private JButton minus;
    private JButton plus;
    private JButton equals;
    private JButton point;
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton zero;

    private String temp;

    // Constructor to setup the GUI components and event handlers
    public Calculator() {
        JPanel panel; // Retrieve the content-pane of the top-level container Jpanel
        JPanel txtDisp;// All operations done on the content-pane

        opType = 0;
        temp = "";
        number = BigDecimal.ZERO;
        pointChkr = false;

        lblSum = new JLabel("0");
        GridLayout gridLayout = new GridLayout(5, 4);
        panel = new JPanel();
        txtDisp = new JPanel();
        Container cp = panel;
        cp.setLayout(gridLayout);   // The content-pane sets its layout

        clear = new JButton("AC");
        sign = new JButton("+/-");
        percent = new JButton("%");
        divide = new JButton("/");
        multiply = new JButton("x");
        minus = new JButton("-");
        plus = new JButton("+");
        equals = new JButton("=");
        point = new JButton(".");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        zero = new JButton("0");

        divide.setBackground(Color.ORANGE);
        multiply.setBackground(Color.ORANGE);
        minus.setBackground(Color.ORANGE);
        plus.setBackground(Color.ORANGE);
        equals.setBackground(Color.ORANGE);

        one.addActionListener(new MyActionListener());
        two.addActionListener(new MyActionListener());
        three.addActionListener(new MyActionListener());
        four.addActionListener(new MyActionListener());
        five.addActionListener(new MyActionListener());
        six.addActionListener(new MyActionListener());
        seven.addActionListener(new MyActionListener());
        eight.addActionListener(new MyActionListener());
        nine.addActionListener(new MyActionListener());
        zero.addActionListener(new MyActionListener());
        plus.addActionListener(new MyActionListener());
        minus.addActionListener(new MyActionListener());
        multiply.addActionListener(new MyActionListener());
        divide.addActionListener(new MyActionListener());
        equals.addActionListener(new MyActionListener());
        clear.addActionListener(new MyActionListener());
        point.addActionListener(new MyActionListener());
        sign.addActionListener(new MyActionListener());

        // add them to container, Panel panel
        panel.add(clear);
        panel.add(percent);
        panel.add(sign);
        panel.add(divide);
        panel.add(seven);
        panel.add(eight);
        panel.add(nine);
        panel.add(multiply);
        panel.add(four);
        panel.add(five);
        panel.add(six);
        panel.add(minus);
        panel.add(one);
        panel.add(two);
        panel.add(three);
        panel.add(plus);
        panel.add(zero);
        panel.add(point);
        panel.add(equals);

        txtDisp.add(lblSum);

        add(txtDisp, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit program if close-window button clicked
        setTitle("My Calculator"); // "super" Jpanel sets title
        setSize(250, 350);         // "super" Jpanel sets initial size
        setVisible(true);          // "super" Jpanel shows
    }

    // 1. provide new class:
    // or 2. anonymous class:
    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (temp.equals("0") || temp.equals(""))
                temp = "";

            if (e.getSource() != plus && e.getSource() != minus && e.getSource() != multiply && e.getSource() != divide && e.getSource() != equals) {
                if (e.getSource() == clear) {
                    temp = "0";
                    lblSum.setText("0");
                    pointChkr = false;
                    number = BigDecimal.ZERO;
                } else if (e.getSource() == one)
                    temp += "1";
                else if (e.getSource() == two)
                    temp += "2";
                else if (e.getSource() == three)
                    temp += "3";
                else if (e.getSource() == four)
                    temp += "4";
                else if (e.getSource() == five)
                    temp += "5";
                else if (e.getSource() == six)
                    temp += "6";
                else if (e.getSource() == seven)
                    temp += "7";
                else if (e.getSource() == eight)
                    temp += "8";
                else if (e.getSource() == nine)
                    temp += "9";
                else if (e.getSource() == zero)
                    temp += "0";
                if (e.getSource() == point && !pointChkr) {
                    pointChkr = true;
                    temp += ".";
                }
                if (e.getSource() == sign) {
                    int bufferInt = Integer.parseInt(temp);
                    bufferInt = -bufferInt;
                    temp = Integer.toString(bufferInt);
                }
                System.out.println(temp);
                lblSum.setText(temp);
            } else {
                //TODO do percent button next
                if (e.getSource() == percent) {
                    ;
                }
                if (e.getSource() == plus) {
                    if (number.equals(BigDecimal.ZERO)) {
                        lblSum.setText("+");
                        number = new BigDecimal(temp);
                        temp = "0";
                        opType = ADDITION;
                    }
                } else if (e.getSource() == minus) {
                    if (number.equals(BigDecimal.ZERO)) {
                        lblSum.setText("-");
                        number = new BigDecimal(temp);
                        temp = "0";
                        opType = SUBTRACTION;
                    }
                } else if (e.getSource() == multiply) {
                    if (number.equals(BigDecimal.ZERO)) {
                        lblSum.setText("x");
                        number = new BigDecimal(temp);
                        temp = "0";
                        opType = MULTIPLICATION;
                    }
                } else if (e.getSource() == divide) {
                    if (number.equals(BigDecimal.ZERO)) {
                        lblSum.setText("/");
                        number = new BigDecimal(temp);
                        temp = "0";
                        opType = DIVISION;
                    }
                } else if (e.getSource() == equals) {
                    try {
                        if (number.equals(BigDecimal.ZERO)) {
                            BigDecimal result = new BigDecimal(lblSum.getText());
                            if (opType == ADDITION) {
                                result = number.add(result);
                            } else if (opType == SUBTRACTION) {
                                result = number.subtract(result);
                            } else if (opType == MULTIPLICATION) {
                                result = number.multiply(result);
                            } else if (opType == DIVISION) {
                                result = number.divide(result, 6, RoundingMode.HALF_UP);
                            }
                            lblSum.setText(result + "");
                            number = BigDecimal.ZERO;
                        }
                    } catch (ArithmeticException zeroException) {
                        lblSum.setText("ERROR");
                        zeroException.printStackTrace();
                    } finally {
                        number = BigDecimal.ZERO;
                        pointChkr = false;
                    }
                }
            }
        }
    }

    // The entry main() method
    public static void main(String[] args) {
        // Run the GUI construction in the Event-Dispatching thread for thread-safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator(); // Let the constructor do the job
            }
        });
    }
}