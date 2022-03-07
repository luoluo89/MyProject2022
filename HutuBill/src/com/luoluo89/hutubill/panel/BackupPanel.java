package com.luoluo89.hutubill.panel;

import com.luoluo89.hutubill.listener.BackupListener;
import com.luoluo89.hutubill.util.ColorUtil;
import com.luoluo89.hutubill.util.GUIUtil;

import javax.swing.*;

public class BackupPanel extends JPanel {
    static{
        GUIUtil.useLNF();
    }

    public static BackupPanel instance = new BackupPanel();
    JButton bBackup =new JButton("备份");

    public BackupPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bBackup);
        this.add(bBackup);
        bBackup.addActionListener(new BackupListener());
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(BackupPanel.instance);
    }

}