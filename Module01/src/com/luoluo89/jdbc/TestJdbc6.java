package com.luoluo89.jdbc;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestJdbc6 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "root");
             Statement s = connection.createStatement();) {

            String sql1 = "select id from hero ORDER BY id asc limit 10";
            ResultSet resultSet = s.executeQuery(sql1);
            List<Integer> list = new ArrayList();
            while (resultSet.next()){
                list.add(resultSet.getInt(1));
            }
            // 关闭自动提交
            connection.setAutoCommit(false);
            for (int i = 0; i < list.size(); i++) {
                System.out.println("将要删除以下ID的数据"+ list.get(i));
            }
            byte[] in = new byte[1];
            try {
                System.out.println("请输入Y确认，或N取消：");
                System.in.read(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (new String(in).equals("Y")){
                for(int id : list){
                String sql2 = "delete from hero where id = " + id;
                s.execute(sql2);
                System.out.println("已删除id为" + id + "的记录。");
                }
            }
            else{
                System.out.println("取消");
            }
            connection.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
