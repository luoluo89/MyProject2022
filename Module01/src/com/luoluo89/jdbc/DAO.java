package com.luoluo89.jdbc;

import com.luoluo89.thread.Hero1;

import java.util.List;

public interface DAO {
    //增加
    public void add(Hero1 hero);
    //修改
    public void update(Hero1 hero);
    //删除
    public void delete(Hero1 hero);
    //获取
    public Hero1 get(int id);
    //查询
    public List<Hero1> list();
    //分页查询
    public List<Hero1> list(int start, int count);
}
