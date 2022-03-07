package com.luoluo89.myswing;

import javax.swing.*;
import java.awt.*;

public class TestGUI8 {
    public static void main(String[] args) {

        JFrame jFrame = new JFrame("LoL");
        jFrame.setSize(400, 300);
        jFrame.setLocation(200, 200);
        jFrame.setLayout(null);
        JPanel pLeft = new JPanel();
        pLeft.setBounds(0, 0, 300, 60);
        pLeft.setBackground(Color.RED);
        pLeft.setLayout(new FlowLayout());
        JButton b1 = new JButton("盖伦");
        JButton b2 = new JButton("提莫");
        JButton b3 = new JButton("安妮");
        pLeft.add(b1);
        pLeft.add(b2);
        pLeft.add(b3);
        JPanel pRight = new JPanel();
        JButton b4 = new JButton("英雄4");
        JButton b5 = new JButton("英雄5");
        JButton b6 = new JButton("英雄6");
        pRight.add(b4);
        pRight.add(b5);
        pRight.add(b6);
        pRight.setBackground(Color.BLUE);
        pRight.setBounds(0, 0, 300, 60);
        // 创建一个水平JSplitPane，左边是p1,右边是p2
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pLeft, pRight);
        // 设置分割条的位置
        sp.setDividerLocation(200);
        // 把sp当作ContentPane
        jFrame.setContentPane(sp);
        JTextArea jTextArea = new JTextArea();
        jTextArea.setText("sjdifjisdjfisjdifjsidjfisdfsdfsdfsdfsdffffffffffffffffffffffffffffffffffffffffffffffffff");
        jTextArea.setLineWrap(true);
        pRight.add(jTextArea);

        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.add(pLeft);
        jTabbedPane.add(pRight);
        // 设置tab的标题
        jTabbedPane.setTitleAt(0, "红色tab");
        jTabbedPane.setTitleAt(1, "蓝色tab");
        jFrame.setContentPane(jTabbedPane);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
