package com.luoluo89.jdbc;

import com.luoluo89.thread.Hero1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestConnectionPool {
    public static void main(String[] args) {
        ConnectionPool connectionPool = new ConnectionPool(5);
        for (int i = 0; i < 1000; i++) {
            new WorkingThread(connectionPool, "Thread"+String.valueOf(i), i).run();
        }
    }

    static class WorkingThread extends Thread {
        ConnectionPool connectionPool;
        String name;
        int index;

        public WorkingThread(ConnectionPool connectionPool, String name,int index) {
            this.connectionPool = connectionPool;
            this.name = name;
            this.index = index;
        }

        @Override
        public void run() {
            Connection connection = connectionPool.getConnection();
            String sql = "select * from hero limit ?, 1";
            PreparedStatement preparedStatement;
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,index);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    System.out.println("查询到的的英雄姓名为：" + resultSet.getString("name"));
                }
                connectionPool.returnConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
