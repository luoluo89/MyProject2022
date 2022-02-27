package com.luoluo89.jdbc;

import java.sql.*;

public class TestJdbc4 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql1 = "insert into hero values(null,?,?,?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
        ) {
            preparedStatement.setString(1, "香菱");
            preparedStatement.setFloat(2, 200.0f);
            preparedStatement.setInt(3, 15);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs != null && rs.next()) {
                int id = rs.getInt(1);
                System.out.println("插入数据成功，ID为：" + id);
                String sql2 = "delete from hero where id = ?";
                PreparedStatement preparedStatement2 = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
                for (int i = id - 1; i > 0; i--) {
                    preparedStatement2.setInt(1, i);
                    int res = preparedStatement2.executeUpdate();
                    if (res == 1) {
                        System.out.println("已删除前一条数据，ID为：" + (i));
                        break;
                    } else {
                        System.out.println("前一条数据不存在");
                        continue;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
