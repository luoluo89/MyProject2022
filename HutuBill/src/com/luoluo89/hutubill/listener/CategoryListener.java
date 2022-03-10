package com.luoluo89.hutubill.listener;

import com.luoluo89.hutubill.entity.Category;
import com.luoluo89.hutubill.panel.CategoryPanel;
import com.luoluo89.hutubill.panel.RecordPanel;
import com.luoluo89.hutubill.service.CategoryService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        CategoryService categoryService = new CategoryService();
        JButton button = (JButton) e.getSource();
        if (button == CategoryPanel.instance.bAdd) {
            //新增
            String name = JOptionPane.showInputDialog("请输入新增分类名称");
            if (name == null || name.isEmpty()){
                return;
            }
            Category category = new Category();
            category.setName(name);
            categoryService.add(category);

        } else if (button == CategoryPanel.instance.bEdit) {
            //编辑
            int selectrow = CategoryPanel.instance.jTable.getSelectedRow();
            Category selectedCategory = CategoryPanel.instance.getSelectedCategory(selectrow);
            String name = JOptionPane.showInputDialog("修改分类名称", CategoryPanel.instance.getSelectedCategory(selectrow).getName());
            if (name == null || name.isEmpty()){
                return;
            }
            selectedCategory.setName(name);
            categoryService.update(selectedCategory);

        } else {
            //删除
            int selectrow = CategoryPanel.instance.jTable.getSelectedRow();
            Category selectedCategory = CategoryPanel.instance.getSelectedCategory(selectrow);
            if (selectedCategory.getRecordNumber() != 0) {
                JOptionPane.showMessageDialog(CategoryPanel.instance, "本分类下有消费记录存在，不能删除");
                return;
            }
            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(CategoryPanel.instance, "确认要删除？"))
                return;
            categoryService.delete(selectedCategory.getId());
        }
        CategoryPanel.instance.updatePanel();
        RecordPanel.instance.updatePanel();
    }
}
