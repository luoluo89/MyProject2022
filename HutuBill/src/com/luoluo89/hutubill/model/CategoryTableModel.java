package com.luoluo89.hutubill.model;

import com.luoluo89.hutubill.dao.CategoryDAO;
import com.luoluo89.hutubill.entity.Category;
import com.luoluo89.hutubill.service.CategoryService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class CategoryTableModel implements TableModel {
 
    String[] columnNames = new String[]{"分类名称","消费次数"};
    public static List<Category> cs = new ArrayList<>();
     
    public CategoryTableModel(){
        CategoryService categoryService = new CategoryService();
        cs = categoryService.list();
    }
    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return cs.size();
    }
 
    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return columnNames.length;
    }
 
    @Override
    public String getColumnName(int columnIndex) {
        // TODO Auto-generated method stub
        return columnNames[columnIndex];
    }
 
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // TODO Auto-generated method stub
        return String.class;
    }
 
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        return false;
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        if(0==columnIndex)
            return cs.get(rowIndex).getName();
        if(1==columnIndex)
            return cs.get(rowIndex).getRecordNumber();
        return null;
    }
 
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
         
    }
 
    @Override
    public void addTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub
         
    }
 
    @Override
    public void removeTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub
         
    }
}