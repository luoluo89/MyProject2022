package com.luoluo89.hutubill.service;

import com.luoluo89.hutubill.dao.CategoryDAO;
import com.luoluo89.hutubill.entity.Category;
import com.luoluo89.hutubill.model.CategoryTableModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    static CategoryDAO dao = new CategoryDAO();

    static {
        init();
    }

    public static void init() {
        //
    }

    public String get(int id) {
        Category category = dao.get(id);
        return category.getName();
    }

    public void update(Category category) {
        dao.update(category);
    }

    public void add(Category category) {
        dao.add(category);
        CategoryTableModel.cs.add(category);
    }

    public List<Category> list() {
        List<Category> list = dao.list();
        return list;
    }

    public void delete(int id) {
/*        List<Category> cs = CategoryTableModel.cs;
        for(Category category : cs){
            if (category.getId() == id){
                cs.remove(category);
            }
        }*/
        dao.delete(id);
    }

}