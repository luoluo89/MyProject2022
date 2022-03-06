package com.luoluo89.myswing;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TestGUI3 {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(1920, 1080);
        f.setLocation(0, 0);
        f.setLayout(null);

        final JLabel l = new JLabel();
        ImageIcon i = new ImageIcon("D:\\04.game\\Genshin Impact\\Genshin Impact Game\\ScreenShot\\20220226131944.png");
        l.setIcon(i);
        l.setBounds(0, 0, i.getIconWidth(), i.getIconHeight());

        // 增加键盘监听
        f.addKeyListener(new KeyListener() {
            // 键被弹起
            public void keyReleased(KeyEvent e) {

            }

            //键被按下
            public void keyPressed(KeyEvent e) {
                // 39代表按下了 “右键”
                if (e.getKeyCode() == 39) {
                    // 图片向右移动 （y坐标不变，x坐标增加）
                    l.setLocation(l.getX() + 10, l.getY());
                }
                if (e.getKeyCode() == 37)
                {
                    l.setLocation(l.getX() - 10, l.getY());
                }
                if (e.getKeyCode() == 38)
                {
                    l.setLocation(l.getX(), l.getY() - 10);
                }
                if (e.getKeyCode() == 40)
                {
                    l.setLocation(l.getX(), l.getY() + 10);
                }
            }

            // 一个按下弹起的组合动作
            public void keyTyped(KeyEvent e) {
            }
        });
        f.add(l);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
