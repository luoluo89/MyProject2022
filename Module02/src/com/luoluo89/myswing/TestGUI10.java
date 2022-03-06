package com.luoluo89.myswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.nio.file.Files;

public class TestGUI10 {
    public static int i;
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("原神角色");
        jFrame.setSize(400, 300);
        jFrame.setLocation(200, 200);

        jFrame.setLayout(null);

        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(50, 50, 300, 60);
        leftPanel.setLayout(new FlowLayout());

        JButton jButton = new JButton("下一张");
        leftPanel.add(jButton);
        JButton jButton2 = new JButton("上一张");
        leftPanel.add(jButton2);

        JPanel rightPanel = new JPanel();
        JLabel jLabel = new JLabel("");

        final ImageIcon[] imageIcon = {new ImageIcon("D:\\02.code\\idea_workspace_03\\MyProject2022\\Module02\\resource\\qq.JPG")};
        jLabel.setIcon(imageIcon[0]);

        rightPanel.add(jLabel);
        rightPanel.setBounds(10, 150, 300, 60);
        // 创建一个水平JSplitPane，左边是p1,右边是p2
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        // 设置分割条的位置
        sp.setDividerLocation(80);
        // 把sp当作ContentPane
        jFrame.setContentPane(sp);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        switchPic(jButton,jLabel);
        switchPic2(jButton2,jLabel);

    }
    private static void switchPic(JButton jButton,JLabel jLabel){
        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count = 0;
                File file = new File("D:\\02.code\\idea_workspace_03\\MyProject2022\\Module02\\resource");
                File[] files = file.listFiles();
                jLabel.setIcon(new ImageIcon(files[++i].getAbsolutePath()));
                System.out.println("++" + i);
                for (File i : files)
                {
                    count++;
                }
                if (i==count-1){
                    i=0;
                }
            }
        });
    }

    private static void switchPic2(JButton jButton,JLabel jLabel){
        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("D:\\02.code\\idea_workspace_03\\MyProject2022\\Module02\\resource");
                File[] files = file.listFiles();
                int count = 0;
                jLabel.setIcon(new ImageIcon(files[--i].getAbsolutePath()));
                System.out.println("--" + i);
                for (File i : files)
                {
                    count++;
                }
                if (i==0){
                    i=files.length;
                }
            }
        });
    }
}
