package com.luoluo89.hutubill.panel;

import com.luoluo89.hutubill.entity.Category;
import com.luoluo89.hutubill.listener.CategoryListener;
import com.luoluo89.hutubill.model.CategoryTableModel;
import com.luoluo89.hutubill.service.CategoryService;
import com.luoluo89.hutubill.util.ColorUtil;
import com.luoluo89.hutubill.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class CategoryPanel extends JPanel {
    static{
        GUIUtil.useLNF();
    }
    public static CategoryPanel instance = new CategoryPanel();
 
    public JButton bAdd = new JButton("新增");
    public JButton bEdit = new JButton("编辑");
    public JButton bDelete = new JButton("删除");

    public CategoryTableModel ctm = new CategoryTableModel();
    public JTable jTable =new JTable(ctm);
     
    public CategoryPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bAdd,bEdit,bDelete);
        JScrollPane sp =new JScrollPane(jTable);
        JPanel pSubmit = new JPanel();
        pSubmit.add(bAdd);
        pSubmit.add(bEdit);
        pSubmit.add(bDelete);
         
        this.setLayout(new BorderLayout());
        this.add(sp,BorderLayout.CENTER);
        this.add(pSubmit,BorderLayout.SOUTH);
        bAdd.addActionListener(new CategoryListener());
        bEdit.addActionListener(new CategoryListener());
        bDelete.addActionListener(new CategoryListener());
    }

    public Category getSelectedCategory(int selectrow){
        return ctm.cs.get(selectrow);
    }

    public void updatePanel(){
        ctm.cs = new CategoryService().list();
        jTable.updateUI();
        jTable.getSelectionModel().setSelectionInterval(0, 0);
    }
 
    public static void main(String[] args) {
        GUIUtil.showPanel(CategoryPanel.instance);
    }
     
}