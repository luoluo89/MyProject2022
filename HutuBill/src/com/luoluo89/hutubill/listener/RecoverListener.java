package com.luoluo89.hutubill.listener;

import com.luoluo89.hutubill.panel.ConfigPanel;
import com.luoluo89.hutubill.util.MysqlUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class RecoverListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String mysqlpath = ConfigPanel.instance.tfMysqlPath.getText();
        File commandFile = new File(mysqlpath,"bin/mysql.exe");
        if (!commandFile.exists()){
            JOptionPane.showMessageDialog(ConfigPanel.instance, "Mysql路径不正确");
            return;
        }
        JFileChooser fc = new JFileChooser();
        int returnVal =  fc.showOpenDialog(ConfigPanel.instance);
        File file = fc.getSelectedFile();
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(ConfigPanel.instance, "计划从:" + file.getAbsolutePath() + "文件恢复。");
            MysqlUtil.recover(mysqlpath,file.getAbsolutePath());
            JOptionPane.showMessageDialog(ConfigPanel.instance, "恢复成功！");
        }
    }
}
