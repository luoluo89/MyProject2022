package com.luoluo89.hutubill.listener;

import com.luoluo89.hutubill.panel.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBarListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainPanel mainPanel = MainPanel.instance;
        JButton button = (JButton) e.getSource();
        if (button.equals(mainPanel.bSpend)) {
            SpendPanel.instance.updateData();
            mainPanel.workingPanel.show(SpendPanel.instance);
        }else if(button.equals(mainPanel.bRecord)) {
            mainPanel.workingPanel.show(RecordPanel.instance);
        }else if(button.equals(mainPanel.bRecord_history)) {
            mainPanel.workingPanel.show(RecordHistoryPanel.instance);
        }
        else if(button.equals(mainPanel.bCategory)) {
            mainPanel.workingPanel.show(CategoryPanel.instance);
        }
        else if(button.equals(mainPanel.bReport)) {
            mainPanel.workingPanel.show(ReportPanel.instance);
        }
        else if(button.equals(mainPanel.bConfig)) {
            mainPanel.workingPanel.show(ConfigPanel.instance);
        }
        else if(button.equals(mainPanel.bBackup)) {
            mainPanel.workingPanel.show(BackupPanel.instance);
        }
        else if(button.equals(mainPanel.bRecover)) {
            mainPanel.workingPanel.show(RecoverPanel.instance);
        }
        else if(button.equals(RecordHistoryPanel.instance.bAdd)) {
            mainPanel.workingPanel.show(RecordPanel.instance);
        }
        else{
            mainPanel.workingPanel.show(SpendPanel.instance);
        }
    }
}
