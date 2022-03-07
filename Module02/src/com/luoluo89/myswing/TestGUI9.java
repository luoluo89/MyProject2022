package com.luoluo89.myswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TestGUI9 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("CardLayerout");

        JPanel comboBoxPane = new JPanel();
        String buttonPanel = "按钮面板";
        String inputPanel = "输入框面板";
        String comboBoxItems[] = { buttonPanel, inputPanel };
        JComboBox<String> cb = new JComboBox<>(comboBoxItems);
        comboBoxPane.add(cb);
        // 两个Panel充当卡片
        JPanel card1 = new JPanel();
        card1.add(new JButton("按钮 1"));
        card1.add(new JButton("按钮 2"));
        card1.add(new JButton("按钮 3"));
        JPanel card2 = new JPanel();
        card2.add(new JTextField("输入框", 20));
        //这个panel是
        JPanel cards;
        cards = new JPanel(new CardLayout());
        cards.add(card1, buttonPanel);
        cards.add(card2, inputPanel);
        jFrame.add(comboBoxPane, BorderLayout.NORTH);
        jFrame.add(cards, BorderLayout.CENTER);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(250, 150);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, (String) evt.getItem());
            }
        });
    }
}
