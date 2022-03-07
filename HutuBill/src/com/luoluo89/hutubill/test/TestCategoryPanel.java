package com.luoluo89.hutubill.test;

import com.luoluo89.hutubill.model.CategoryComboBoxModel;
import com.luoluo89.hutubill.model.CategoryTableModel;
import com.luoluo89.hutubill.panel.CenterPanel;
import com.luoluo89.hutubill.util.GUIUtil;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class TestCategoryPanel {
    static{
        GUIUtil.useLNF();
    }
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(500,500);
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

        //上边
        CategoryTableModel ctm = new CategoryTableModel();
        JTable t =new JTable(ctm);
        JScrollPane sp =new JScrollPane(t);

        //下边
        JPanel jPaneldown = new JPanel();
        jPaneldown.setLayout(new FlowLayout());
        JButton bAdd = new JButton("新增");
        JButton bEdit = new JButton("编辑");
        JButton bDelete = new JButton("删除");
        jPaneldown.add(bAdd);
        jPaneldown.add(bEdit);
        jPaneldown.add(bDelete);

        //
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(sp,BorderLayout.CENTER);
        jPanel2.add(jPaneldown,BorderLayout.SOUTH);

        CenterPanel cp = new CenterPanel(0.85);
        jFrame.setContentPane(cp);
        cp.setLayout(new BorderLayout());
        cp.add(jToolBar,BorderLayout.NORTH);
        cp.add(jPanel2,BorderLayout.CENTER);
        // 关闭窗体的时候，退出程序
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 让窗体变得可见
        jFrame.setVisible(true);
    }
}
