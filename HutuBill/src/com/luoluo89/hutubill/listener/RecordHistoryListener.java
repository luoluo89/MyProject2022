package com.luoluo89.hutubill.listener;

import com.luoluo89.hutubill.entity.Category;
import com.luoluo89.hutubill.entity.Record;
import com.luoluo89.hutubill.panel.*;
import com.luoluo89.hutubill.service.CategoryService;
import com.luoluo89.hutubill.service.RecordService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordHistoryListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        RecordService recordService = new RecordService();
        JButton button = (JButton) e.getSource();
        if (button == RecordHistoryPanel.instance.bAdd) {
            SpendPanel.instance.updateData();
            MainPanel.instance.workingPanel.show(SpendPanel.instance);
        } else if (button == RecordHistoryPanel.instance.bEdit) {
            //编辑
            int selectrow = RecordHistoryPanel.instance.jTable.getSelectedRow();
            Record selectedRecord = RecordHistoryPanel.instance.getSelectedRecord(selectrow);
            //打开记一笔面板
            recordService.update(selectedRecord);
        } else {
            //删除
            int selectrow = RecordHistoryPanel.instance.jTable.getSelectedRow();
            Record selectedrecord = RecordHistoryPanel.instance.getSelectedRecord(selectrow);
            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(RecordHistoryPanel.instance, "确认要删除？"))
                return;
            recordService.delete(selectedrecord.getId());
        }
        RecordHistoryPanel.instance.updatePanel();
        SpendPanel.instance.updateData();
    }
}
