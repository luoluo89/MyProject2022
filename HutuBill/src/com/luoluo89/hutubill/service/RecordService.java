package com.luoluo89.hutubill.service;

import com.luoluo89.hutubill.dao.CategoryDAO;
import com.luoluo89.hutubill.dao.RecordDAO;
import com.luoluo89.hutubill.entity.Category;
import com.luoluo89.hutubill.entity.Record;
import com.luoluo89.hutubill.model.CategoryTableModel;

import java.util.Date;
import java.util.List;

public class RecordService {

    static RecordDAO dao = new RecordDAO();


    public void update(Record record) {
        dao.update(record);
    }

    public void add(Record record) {
        dao.add(record);
    }

    public void add(int spend, int cid, String comment, Date date)  {
        Record record = new Record();
        record.setSpend(spend);
        record.setCid(cid);
        record.setComment(comment);
        record.setDate(date);
        dao.add(record);
    }

    public List<Record> list() {
        List<Record> list = dao.list();
        return list;
    }

    public void delete(int id) {
        dao.delete(id);
    }


}