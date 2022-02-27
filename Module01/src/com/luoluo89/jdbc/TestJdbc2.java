package com.luoluo89.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * PreparedStatement的使用
 * 将connection preparedStatement放到try中，try执行完成后可自动关闭
 */
public class TestJdbc2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "insert into hero values(null,?,?,?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ){
            preparedStatement.setString(1,"大兵");
            preparedStatement.setFloat(2,500.0f);
            preparedStatement.setInt(3,2);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
