package com.luoluo89.hutubill.test;

import com.luoluo89.hutubill.util.CircleProgressBar;
import com.luoluo89.hutubill.util.ColorUtil;
import com.luoluo89.hutubill.util.DBUtil;
import com.luoluo89.hutubill.util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class TestSpendPanel {
    static{
        GUIUtil.useLNF();
    }
    public static void main(String[] args) {

        JFrame jFrame = new JFrame();
        jFrame.setSize(800,800);
        jFrame.setLocationRelativeTo(null);

        //上边按钮栏
        JToolBar jToolBar = new JToolBar();
        JLabel homeLabel = new JLabel();
        JLabel recordLabel = new JLabel();
        JLabel category2Label = new JLabel();
        JLabel reportLabel = new JLabel();
        JLabel configLabel = new JLabel();
        JLabel backupLabel = new JLabel();
        JLabel restoreLabel = new JLabel();
        homeLabel.setIcon(new ImageIcon("D:\\02.code\\idea_workspace_03\\MyProject2022\\HutuBill\\resource\\home.png"));
        recordLabel.setIcon(new ImageIcon("D:\\02.code\\idea_workspace_03\\MyProject2022\\HutuBill\\resource\\record.png"));
        category2Label.setIcon(new ImageIcon("D:\\02.code\\idea_workspace_03\\MyProject2022\\HutuBill\\resource\\category2.png"));
        reportLabel.setIcon(new ImageIcon("D:\\02.code\\idea_workspace_03\\MyProject2022\\HutuBill\\resource\\report.png"));
        configLabel.setIcon(new ImageIcon("D:\\02.code\\idea_workspace_03\\MyProject2022\\HutuBill\\resource\\config.png"));
        backupLabel.setIcon(new ImageIcon("D:\\02.code\\idea_workspace_03\\MyProject2022\\HutuBill\\resource\\backup.png"));
        restoreLabel.setIcon(new ImageIcon("D:\\02.code\\idea_workspace_03\\MyProject2022\\HutuBill\\resource\\restore.png"));
        homeLabel.setText("消费一览");
        recordLabel.setText("记一笔");
        category2Label.setText("消费分类");
        reportLabel.setText("月消费报表");
        configLabel.setText("设置");
        backupLabel.setText("备份");
        restoreLabel.setText("恢复");
        jToolBar.add(homeLabel);
        jToolBar.add(recordLabel);
        jToolBar.add(category2Label);
        jToolBar.add(reportLabel);
        jToolBar.add(configLabel);
        jToolBar.add(backupLabel);
        jToolBar.add(restoreLabel);
        jFrame.add(jToolBar,BorderLayout.NORTH);

        //
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new BorderLayout());

        //进度条
        JPanel jPanelbar = new JPanel();
        jPanelbar.setLayout(new BorderLayout());
        CircleProgressBar circleProgressBar = new CircleProgressBar();
        circleProgressBar.setBackgroundColor(Color.green);
        circleProgressBar.setProgress(10);
        jPanelbar.add(circleProgressBar);
        jPanel2.add(jPanelbar,BorderLayout.CENTER);

        //左边
        JPanel jPanelwest = new JPanel();
        jPanelwest.setLayout(new GridLayout(4,1));
        JLabel lMonthSpend = new JLabel("本月消费");
        JLabel vMonthSpend = new JLabel("￥2300");
        JLabel lTodaySpend = new JLabel("今日消费");
        JLabel vTodaySpend = new JLabel("￥25");
        jPanelwest.add(lMonthSpend);
        jPanelwest.add(lTodaySpend);
        jPanelwest.add(vMonthSpend);
        jPanelwest.add(vTodaySpend);
        jPanel2.add(jPanelwest,BorderLayout.WEST);

        //下边
        JPanel jPanelsouth = new JPanel();
        jPanelsouth.setLayout(new GridLayout(2,4));
        JLabel lAvgSpendPerDay = new JLabel("日均消费");
        JLabel lMonthLeft = new JLabel("本月剩余");
        JLabel lDayAvgAvailable = new JLabel("日均可用");
        JLabel lMonthLeftDay = new JLabel("距离月末");
        JLabel vAvgSpendPerDay = new JLabel("￥120");
        JLabel vMonthAvailable = new JLabel("￥2084");
        JLabel vDayAvgAvailable = new JLabel("￥389");
        JLabel vMonthLeftDay = new JLabel("15天");
        jPanelsouth.add(lAvgSpendPerDay);
        jPanelsouth.add(lMonthLeft);
        jPanelsouth.add(lDayAvgAvailable);
        jPanelsouth.add(lMonthLeftDay);
        jPanelsouth.add(vAvgSpendPerDay);
        jPanelsouth.add(vMonthAvailable);
        jPanelsouth.add(vDayAvgAvailable);
        jPanelsouth.add(vMonthLeftDay);
        jPanel2.add(jPanelsouth,BorderLayout.SOUTH);

        GUIUtil.setColor(ColorUtil.grayColor, lMonthSpend, lTodaySpend, lAvgSpendPerDay, lMonthLeft, lDayAvgAvailable,
                lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable, vMonthLeftDay);
        GUIUtil.setColor(ColorUtil.blueColor, vMonthSpend, vTodaySpend);


        jFrame.add(jPanel2,BorderLayout.CENTER);
        // 关闭窗体的时候，退出程序
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 让窗体变得可见
        jFrame.setVisible(true);

    }
}
