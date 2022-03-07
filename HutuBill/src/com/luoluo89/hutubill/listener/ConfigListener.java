package com.luoluo89.hutubill.listener;

import com.luoluo89.hutubill.panel.ConfigPanel;
import com.luoluo89.hutubill.service.ConfigService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ConfigListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField tfBudget = ConfigPanel.instance.tfBudget;
        if(Integer.parseInt(tfBudget.getText()) < 0)
        {
            JOptionPane.showMessageDialog(ConfigPanel.instance, "预算金额不能为负数");
            return;
            //预算不能为负数
        }
        String mysqlpath = ConfigPanel.instance.tfMysqlPath.getText();
        File commandFile = new File(mysqlpath,"bin/mysql.exe");
        if (!commandFile.exists()){
            JOptionPane.showMessageDialog(ConfigPanel.instance, "Mysql路径不正确");
            return;
        }
        ConfigService configService = new ConfigService();
        configService.update(ConfigService.budget,tfBudget.getText());
        configService.update(ConfigService.mysqlPath,ConfigPanel.instance.tfMysqlPath.getText());
        JOptionPane.showMessageDialog(ConfigPanel.instance, "更新成功");
    }
}
