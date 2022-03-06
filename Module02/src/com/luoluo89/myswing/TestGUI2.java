package com.luoluo89.myswing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestGUI2 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("iiii");
        JLabel jLabel = new JLabel();
        jFrame.setLayout(null);
        jFrame.setSize(1920, 1080);
        jFrame.setLocation(0, 0);
        jFrame.add(jLabel);
        ImageIcon imageIcon = new ImageIcon("D:\\04.game\\Genshin Impact\\Genshin Impact Game\\ScreenShot\\20220226131944.png");
        jLabel.setIcon(imageIcon);
        jLabel.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());

        JButton b = new JButton("隐藏图片");
        b.setBounds(150, 200, 100, 30);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jLabel.isVisible()) {
                    jLabel.setVisible(false);
                    b.setText("显示图片");
                } else {
                    jLabel.setVisible(true);
                    b.setText("隐藏图片");
                }
            };
        });
        jFrame.add(b);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
