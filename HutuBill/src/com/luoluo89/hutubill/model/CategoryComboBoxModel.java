package com.luoluo89.hutubill.model;

import com.luoluo89.hutubill.entity.Category;
import com.luoluo89.hutubill.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class CategoryComboBoxModel implements ComboBoxModel<Category> {
    public List<Category> cs = new ArrayList<>();

    Category c;

    public CategoryComboBoxModel() {
        CategoryService categoryService = new CategoryService();
        cs = categoryService.list();
        c = cs.get(0);
    }

    @Override
    public int getSize() {
        return cs.size();
    }

    @Override
    public Category getElementAt(int index) {
        return cs.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setSelectedItem(Object anItem) {
        c = (Category) anItem;

    }

    @Override
    public Object getSelectedItem() {
        return c;
    }

}