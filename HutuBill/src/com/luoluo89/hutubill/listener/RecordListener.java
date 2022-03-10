package com.luoluo89.hutubill.listener;

import com.luoluo89.hutubill.entity.Category;
import com.luoluo89.hutubill.entity.Record;
import com.luoluo89.hutubill.panel.CategoryPanel;
import com.luoluo89.hutubill.panel.ConfigPanel;
import com.luoluo89.hutubill.panel.RecordPanel;
import com.luoluo89.hutubill.panel.SpendPanel;
import com.luoluo89.hutubill.service.ConfigService;
import com.luoluo89.hutubill.service.RecordService;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField tfSpend = RecordPanel.instance.tfSpend;
        JComboBox<Category> cbCategory = RecordPanel.instance.cbCategory;
        JTextField tfComment = RecordPanel.instance.tfComment;
        JXDatePicker datepick = RecordPanel.instance.datepick;
        int spend = 0;
        try {
            spend = Integer.parseInt(tfSpend.getText());
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(RecordPanel.instance, "请输入正确的花费金额");
            return;
        }
        if (spend <= 0) {
            JOptionPane.showMessageDialog(RecordPanel.instance, "请输入正确的花费金额");
            return;
        }
        if (RecordPanel.instance.cbModel.cs.isEmpty()) {
            JOptionPane.showMessageDialog(RecordPanel.instance, "请先添加消费分类");
            return;
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
       /* if(datepick.getDate().)
        {
            JOptionPane.showMessageDialog(RecordPanel.instance, "请输入正确的花费金额");
        }*/
        RecordService recordService = new RecordService();
        recordService.add(spend, ((Category) cbCategory.getSelectedItem()).getId(), tfComment.getText(), datepick.getDate());
        JOptionPane.showMessageDialog(ConfigPanel.instance, "记账成功");
        CategoryPanel.instance.updatePanel();
        SpendPanel.instance.updateData();
    }
}
