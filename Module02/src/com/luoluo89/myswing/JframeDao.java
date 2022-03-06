package com.luoluo89.myswing;

import java.sql.*;

public class JframeDao {
    public JframeDao(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void add(Coordinate coordinate) {
        try (Connection connection = getConnection();
             Statement s = connection.createStatement();) {
            String sql = "insert into coordinate values(" + coordinate.getId() + ","  + coordinate.getX() + "," + coordinate.getY() + ")";
            s.execute(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Coordinate get() {
        Coordinate coordinate = null;
        try (Connection connection = getConnection();
             Statement s = connection.createStatement();) {
            String sql = "select * from coordinate";
            ResultSet resultSet = s.executeQuery(sql);
            if (resultSet.next()) {
                coordinate = new Coordinate();
                coordinate.setId(resultSet.getInt("id"));
                coordinate.setX(resultSet.getInt("x"));
                coordinate.setY(resultSet.getInt("y"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return coordinate;
    }

    public void update(Coordinate coordinate) {
        String sql = "update coordinate set x = ? , y = ? where id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setInt(1, coordinate.getX());
            ps.setInt(2, coordinate.getY());
            ps.setInt(3, coordinate.getId());
            ps.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "root");
    }
}
