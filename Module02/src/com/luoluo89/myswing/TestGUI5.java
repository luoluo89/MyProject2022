package com.luoluo89.myswing;

import javax.swing.*;
import java.awt.*;

public class TestGUI5 {
    public static void main(String[] args) {

        JFrame jFrame1 = new JFrame("LoL1");
        jFrame1.setSize(400, 300);
        jFrame1.setLocation(200, 200);
        // 设置布局器为FlowLayerout
        // 容器上的组件水平摆放
        jFrame1.setLayout(new FlowLayout());
        JButton b1 = new JButton("洪七公");
        JButton b2 = new JButton("段智兴");
        JButton b3 = new JButton("欧阳锋");
        JButton b4 = new JButton("黄药师");
        JButton b5 = new JButton("王重阳");
        // 加入到容器即可，无需单独指定大小和位置
        jFrame1.add(b1);
        jFrame1.add(b2);
        jFrame1.add(b3);
        jFrame1.add(b4);
        jFrame1.add(b5);
        jFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame1.setVisible(true);

        JFrame jFrame2 = new JFrame("LoL2");
        jFrame2.setSize(400, 300);
        jFrame2.setLocation(800, 200);
        // 设置布局器为BorderLayerout
        // 容器上的组件按照上北下南左西右东中的顺序摆放
        jFrame2.setLayout(new BorderLayout());
        // 加入到容器的时候，需要指定位置
        JButton c1 = new JButton("洪七公");
        JButton c2 = new JButton("段智兴");
        JButton c3 = new JButton("欧阳锋");
        JButton c4 = new JButton("黄药师");
        JButton c5 = new JButton("王重阳");
        jFrame2.add(c1, BorderLayout.NORTH);
        jFrame2.add(c2, BorderLayout.SOUTH);
        jFrame2.add(c3, BorderLayout.WEST);
        jFrame2.add(c4, BorderLayout.EAST);
        jFrame2.add(c5, BorderLayout.CENTER);
        jFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame2.setVisible(true);

        JFrame jFrame3 = new JFrame("LoL2");
        jFrame3.setSize(400, 300);
        jFrame3.setLocation(1400, 200);
        // 设置布局器为BorderLayerout
        // 容器上的组件按照上北下南左西右东中的顺序摆放
        jFrame3.setLayout(new GridLayout(2,3));
        // 加入到容器的时候，需要指定位置
        JButton d1 = new JButton("洪七公");
        JButton d2 = new JButton("段智兴");
        JButton d3 = new JButton("欧阳锋");
        JButton d4 = new JButton("黄药师");
        JButton d5 = new JButton("王重阳");
        jFrame3.add(d1, BorderLayout.NORTH);
        jFrame3.add(d2, BorderLayout.SOUTH);
        jFrame3.add(d3, BorderLayout.WEST);
        jFrame3.add(d4, BorderLayout.EAST);
        jFrame3.add(d5, BorderLayout.CENTER);
        jFrame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame3.setVisible(true);

    }
}
