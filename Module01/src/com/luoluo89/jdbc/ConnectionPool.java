package com.luoluo89.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库连接池，初始化时指定连接数，建立多个连接
 * 通过getConnection获取一个连接，用完通过returnConnection归还，不关闭
 * 如果connection已经被用完，则等待
 */
public class ConnectionPool {

    private int size;
    private List<Connection> list;

    public ConnectionPool(int size) {
        list = new ArrayList<>();
        this.size = size;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for (int i = 0; i < size; i++) {
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "root");
                list.add(connection);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public synchronized Connection getConnection() {
        while (list.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return list.remove(0);
    }

    public synchronized void returnConnection(Connection c) {
        list.add(c);
        this.notifyAll();
    }
}
