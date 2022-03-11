package com.luoluo89.hutubill.panel;

import com.luoluo89.hutubill.entity.Category;
import com.luoluo89.hutubill.entity.Record;
import com.luoluo89.hutubill.listener.CategoryListener;
import com.luoluo89.hutubill.listener.RecordHistoryListener;
import com.luoluo89.hutubill.listener.ToolBarListener;
import com.luoluo89.hutubill.model.CategoryTableModel;
import com.luoluo89.hutubill.model.RecordTableModel;
import com.luoluo89.hutubill.service.CategoryService;
import com.luoluo89.hutubill.service.RecordService;
import com.luoluo89.hutubill.util.ColorUtil;
import com.luoluo89.hutubill.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class RecordHistoryPanel extends JPanel {
    static{
        GUIUtil.useLNF();
    }
    public static RecordHistoryPanel instance = new RecordHistoryPanel();

    public JButton bAdd = new JButton("新增");
    public JButton bEdit = new JButton("编辑");
    public JButton bDelete = new JButton("删除");

    public RecordTableModel ctm = new RecordTableModel();
    public JTable jTable =new JTable(ctm);

    public RecordHistoryPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bAdd,bEdit,bDelete);
        JScrollPane sp =new JScrollPane(jTable);
        JPanel pSubmit = new JPanel();
        pSubmit.add(bAdd);
        pSubmit.add(bEdit);
        pSubmit.add(bDelete);
         
        this.setLayout(new BorderLayout());
        this.add(sp,BorderLayout.CENTER);
        this.add(pSubmit,BorderLayout.SOUTH);
        bAdd.addActionListener(new RecordHistoryListener());
        bEdit.addActionListener(new RecordHistoryListener());
        bDelete.addActionListener(new RecordHistoryListener());
    }

    public Record getSelectedRecord(int selectrow){
        return ctm.cs.get(selectrow);
    }

    public void updatePanel(){
        ctm.cs = new RecordService().list();
        jTable.updateUI();
        jTable.getSelectionModel().setSelectionInterval(0, 0);
    }
 
    public static void main(String[] args) {
        GUIUtil.showPanel(RecordHistoryPanel.instance);
    }
     
}