package com.luoluo89.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc5 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "root");
             Statement s = connection.createStatement();) {

            // 有事务的前提下
            // 在事务中的多个操作，要么都成功，要么都失败
            connection.setAutoCommit(false);

            // 加血的SQL
            String sql1 = "update hero set hp = hp +1 where id = 38366";
            s.execute(sql1);

            // 减血的SQL
            // 不小心写错写成了 updata(而非update)

            String sql2 = "updata hero set hp = hp -1 where id = 38366";
            s.execute(sql2);

            // 手动提交
            connection.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
