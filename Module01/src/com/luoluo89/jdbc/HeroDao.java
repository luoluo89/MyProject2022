package com.luoluo89.jdbc;

import com.luoluo89.thread.Hero1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDao implements DAO {

    public HeroDao(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Hero1 get(int id) {
        Hero1 hero1 = null;
        try (Connection connection = getConnection();
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

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "root");
    }

    @Override
    public void add(Hero1 h) {
        try (Connection connection = getConnection();
             Statement s = connection.createStatement();) {
            String sql = "insert into hero values(null," + h.getName() + "," + h.getHp() + "," + h.getDamage() + ")";
            s.execute(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Hero1 h) {
        String sql = "delete from hero where id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setInt(1, h.getId());
            ps.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void update(Hero1 h) {
        String sql = "update hero set name = ? , hp = ? , damage = ? where id = ?";
        try (Connection connection = getConnection();
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

    @Override
    public List<Hero1> list() {
        List<Hero1> hero1List = new ArrayList<>();
        String sql = "select * from hero";
        try (Connection connection = getConnection();
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

    @Override
    public List<Hero1> list(int start, int count) {
        List<Hero1> hero1List = new ArrayList<>();
        String sql = "select * from hero order by id asc limit ?, ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet resultSet = ps.executeQuery();
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

}
