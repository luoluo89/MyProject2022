package com.luoluo89.jdbc;

import com.luoluo89.thread.Hero1;
import com.luoluo89.thread.Hero2;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestJdbc7 {

    public static Hero1 get(int id) {
        Hero1 hero1 = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "root");
             Statement s = connection.createStatement();) {
            String sql = "select * from hero where id = " + id;
            ResultSet resultSet = s.executeQuery(sql);
            if (resultSet.next()) {
                hero1 = new Hero1();
                hero1.setId(resultSet.getInt("id"));
                hero1.setName(resultSet.getString("name"));
                hero1.setHp(resultSet.getFloat("hp"));
                hero1.setDamage(resultSet.getInt("damage"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return hero1;
    }

    public static void add(Hero1 h) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "root");
             Statement s = connection.createStatement();) {
            String sql = "insert into hero values(null," + h.getName() + "," + h.getHp() + "," + h.getDamage() + ")";
            s.execute(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void delete(Hero1 h) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "delete from hero where id = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "root");
             PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setInt(1, h.getId());
            ps.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void update(Hero1 h) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "update hero set name = ? , hp = ? , damage = ? where id = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "root");
             PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setString(1, h.getName());
            ps.setFloat(2, h.getHp());
            ps.setInt(3, h.getDamage());
            ps.setInt(4, h.getId());
            ps.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static List<Hero1> list() {
        List<Hero1> hero1List = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "select * from hero";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "root");
             Statement ps = connection.createStatement();) {
            ResultSet resultSet = ps.executeQuery(sql);
            while (resultSet.next()) {
                Hero1 hero1 = new Hero1();
                hero1.setId(resultSet.getInt("id"));
                hero1.setName(resultSet.getString("name"));
                hero1.setHp(resultSet.getFloat("hp"));
                hero1.setDamage(resultSet.getInt("damage"));
                hero1List.add(hero1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return hero1List;
    }

    public static void main(String[] args) {
        Hero1 hero1 = new Hero1();
        hero1.setName("'ddd'");
        hero1.setHp(10000f);
        hero1.setDamage(2);
        add(hero1);

        Hero1 hero2 = new Hero1();
        hero2.setId(38367);
        delete(hero2);

        hero1.setId(38368);
        hero1.setName("fjiiejfi");
        update(hero1);
        List<Hero1> hero1List = list();
    }
}
