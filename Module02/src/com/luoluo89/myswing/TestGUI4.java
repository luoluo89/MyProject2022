package com.luoluo89.myswing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestGUI4 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("外部窗体");
        jFrame.setSize(800, 600);
        jFrame.setLocation(100, 100);

        // 根据外部窗体实例化JDialog
        JDialog jDialog = new JDialog(jFrame);
        // 设置为模态,其背后的父窗体，是不能被激活的，除非该对话框被关闭
        jDialog.setModal(true);

        jDialog.setTitle("模态的对话框");
        jDialog.setSize(400, 300);
        jDialog.setLocation(200, 200);
        jDialog.setLayout(null);
        JButton jButton = new JButton("锁定调整大小");
        jButton.setBounds(50, 50, 280, 30);
        jDialog.add(jButton);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口不能调整大小
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jDialog.isResizable()) {
                    jDialog.setResizable(false);
                    jButton.setText("解锁调整大小");
                } else {
                    jDialog.setResizable(false);
                    jButton.setText("锁定调整大小");
                }
            };
        });
        jFrame.setVisible(true);
        jDialog.setVisible(true);

    }
}
