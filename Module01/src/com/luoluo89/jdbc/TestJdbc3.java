package com.luoluo89.jdbc;

import java.sql.*;
import java.util.Date;

/**
 *
 *PreparedStatement有预编译机制，性能比Statement更快
 */
public class TestJdbc3 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            callStatement(i);
        }
        long t2 = new Date().getTime();
        System.out.printf("Statment time : %d", t2 - t1);
        System.out.println();

        long t3 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            callPrepareStatement(i);
        }
        long t4 = new Date().getTime();
        System.out.printf("PrepareStatement time : %d", t4 - t3);
    }

    private static void callStatement(int i) {
        String name = "'小将" + i + "'";
        String sql1 = "insert into hero values(null," + name + "," + i + "," + i + ")";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "root");
             Statement statement = connection.createStatement();
        ) {
            statement.execute(sql1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void callPrepareStatement(int i) {
        String sql2 = "insert into hero values(null,?,?,?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(sql2);
        ) {
            String name = "大兵" + i;
            Float f = 500.0f + i;
            int x = 20 + i;
            preparedStatement.setString(1, name);
            preparedStatement.setFloat(2, f);
            preparedStatement.setInt(3, x);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
