package com.luoluo89.hutubill.model;

import com.luoluo89.hutubill.entity.Category;
import com.luoluo89.hutubill.entity.Record;
import com.luoluo89.hutubill.service.CategoryService;
import com.luoluo89.hutubill.service.RecordService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class RecordTableModel implements TableModel {

    String[] columnNames = new String[]{"花费","分类","备注","日期"};
    public static List<Record> cs = new ArrayList<>();
    public CategoryService categoryService = new CategoryService();

    public RecordTableModel(){
        RecordService recordService = new RecordService();
        cs = recordService.list();
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
            return cs.get(rowIndex).getSpend();
        if(1==columnIndex){
            int cid = cs.get(rowIndex).getCid();
            return categoryService.get(cid);
        }
        if(2==columnIndex)
            return cs.get(rowIndex).getComment();
        if(3==columnIndex)
            return cs.get(rowIndex).getDate();
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