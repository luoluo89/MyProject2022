package com.luoluo89.myswing;

import javax.swing.*;
import java.awt.*;

public class TestGUI6 {
    public static void main(String[] args) {

        JFrame jFrame = new JFrame("计算器");
        int gap = 8;
        jFrame.setSize(322, 272);
        jFrame.setLocation(200, 200);
        jFrame.setLayout(null);
        JPanel jPanel = new JPanel();
        jPanel.setBounds(gap, gap, 300, 225);
        jFrame.add(jPanel);
        jPanel.setLayout(new GridLayout(4, 5,gap,gap));
        jPanel.add(new JButton("7"));
        jPanel.add(new JButton("8"));
        jPanel.add(new JButton("9"));
        jPanel.add(new JButton("/"));
        jPanel.add(new JButton("sq"));
        jPanel.add(new JButton("4"));
        jPanel.add(new JButton("5"));
        jPanel.add(new JButton("6"));
        jPanel.add(new JButton("*"));
        jPanel.add(new JButton("%"));
        jPanel.add(new JButton("1"));
        jPanel.add(new JButton("2"));
        jPanel.add(new JButton("3"));
        jPanel.add(new JButton("-"));
        jPanel.add(new JButton("1/x"));
        jPanel.add(new JButton("0"));
        jPanel.add(new JButton("+/-"));
        jPanel.add(new JButton("."));
        jPanel.add(new JButton("+"));
        jPanel.add(new JButton("="));

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.setVisible(true);
    }
}
