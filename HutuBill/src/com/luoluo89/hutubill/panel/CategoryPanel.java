package com.luoluo89.hutubill.panel;

import com.luoluo89.hutubill.model.CategoryTableModel;
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
    public JTable t =new JTable(ctm);
     
    public CategoryPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bAdd,bEdit,bDelete);
        JScrollPane sp =new JScrollPane(t);
        JPanel pSubmit = new JPanel();
        pSubmit.add(bAdd);
        pSubmit.add(bEdit);
        pSubmit.add(bDelete);
         
        this.setLayout(new BorderLayout());
        this.add(sp,BorderLayout.CENTER);
        this.add(pSubmit,BorderLayout.SOUTH);
    }
 
    public static void main(String[] args) {
        GUIUtil.showPanel(CategoryPanel.instance);
    }
     
}