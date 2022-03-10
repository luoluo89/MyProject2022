package com.luoluo89.hutubill.panel;

import com.luoluo89.hutubill.dao.ConfigDAO;
import com.luoluo89.hutubill.listener.ConfigListener;
import com.luoluo89.hutubill.service.ConfigService;
import com.luoluo89.hutubill.util.ColorUtil;
import com.luoluo89.hutubill.util.DBUtil;
import com.luoluo89.hutubill.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    static{
        GUIUtil.useLNF();
    }
    public static ConfigPanel instance = new ConfigPanel();

    JLabel lBudget = new JLabel("本月预算(￥)");
    public JTextField tfBudget = new JTextField("0");
     
    JLabel lMysql = new JLabel("Mysql安装目录");
    public JTextField tfMysqlPath = new JTextField("");

    JLabel luser = new JLabel("Mysql用户名");
    public JTextField tfUser = new JTextField(DBUtil.loginName);

    JLabel lpasswd = new JLabel("Mysql密码");
    public JTextField tfPasswd = new JTextField(DBUtil.password);
 
    JButton bSubmit = new JButton("更新");
 
    public ConfigPanel() {
        GUIUtil.setColor(ColorUtil.grayColor, lBudget,lMysql,luser,lpasswd);
        GUIUtil.setColor(ColorUtil.blueColor, bSubmit);
         
        JPanel pInput =new JPanel();
        JPanel pSubmit = new JPanel();
        int gap =40;
        pInput.setLayout(new GridLayout(4,1,gap,gap));
         
        pInput.add(lBudget);
        pInput.add(tfBudget);
        pInput.add(lMysql);
        pInput.add(tfMysqlPath);
        pInput.add(luser);
        pInput.add(tfUser);
        pInput.add(lpasswd);
        pInput.add(tfPasswd);
        this.setLayout(new BorderLayout());
        this.add(pInput,BorderLayout.NORTH);
         
        pSubmit.add(bSubmit);
        this.add(pSubmit,BorderLayout.CENTER);

        bSubmit.addActionListener(new ConfigListener());

        //从数据库读出
        tfBudget.setText(ConfigService.configBudget.getValue());
        tfMysqlPath.setText(ConfigService.configMysqlPath.getValue());

    }
 
    public static void main(String[] args) {
        GUIUtil.showPanel(ConfigPanel.instance);
    }
     
}