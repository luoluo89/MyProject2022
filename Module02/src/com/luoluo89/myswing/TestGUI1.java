package com.luoluo89.myswing;

import javax.swing.*;

/**
 * 测试类，打开一个窗口，程序记录窗口位置并保存到数据库
 * 下次打开窗口，位置采用上次关闭的位置
 */
public class TestGUI1 {
    public static void main(String[] args) {
        // 主窗体
        JFrame f = new JFrame("LoL");
        // 主窗体设置大小
        f.setSize(400, 300);

        JframeDao jframeDao = new JframeDao();
        Coordinate coordinate = jframeDao.get();
        if (null != coordinate) {
            // 主窗体设置位置
            f.setLocation(coordinate.getX(), coordinate.getY());
        } else {
            coordinate = new Coordinate(200, 200);
            coordinate.setId(1);
            f.setLocation(200, 200);
            jframeDao.add(coordinate);
        }

        // 主窗体中的组件设置为绝对定位
        f.setLayout(null);
        // 按钮组件
        JButton b = new JButton("一键秒对方基地挂");
        // 同时设置组件的大小和位置
        b.setBounds(50, 50, 280, 30);
        // 把按钮加入到主窗体中
        f.add(b);
        // 关闭窗体的时候，退出程序
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 让窗体变得可见
        f.setVisible(true);

        new SwitThread(f, jframeDao).run();

    }

    public static class SwitThread extends Thread {
        private Coordinate coordinate;
        private JFrame jFrame;
        private JframeDao jframeDao;

        public SwitThread(JFrame jFrame, JframeDao jframeDao) {
            Coordinate c = jframeDao.get();
            if (null != c){
                this.coordinate = c;
            }
            else {
                coordinate = new Coordinate(200, 200);
                coordinate.setId(1);
            }
            this.jFrame = jFrame;
            this.jframeDao = jframeDao;
        }

        @Override
        public void run() {
            while (true) {
                this.coordinate.setX(jFrame.getX());
                this.coordinate.setY(jFrame.getY());
                this.jframeDao.update(coordinate);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
