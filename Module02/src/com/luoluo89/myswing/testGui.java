package com.luoluo89.myswing;

import javax.swing.*;

public class testGui {
    private JPanel panel1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("testGui");
        frame.setContentPane(new testGui().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
