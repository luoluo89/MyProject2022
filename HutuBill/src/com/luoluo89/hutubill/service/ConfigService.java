package com.luoluo89.hutubill.service;

import com.luoluo89.hutubill.dao.ConfigDAO;
import com.luoluo89.hutubill.entity.Config;

public class ConfigService {
    public static Config configBudget = new Config();
    public static Config configMysqlPath = new Config();
    public static final String budget = "budget";
    public static final String mysqlPath = "mysqlPath";
    public static final String budget_value = "0";
    public static final String mysqlPath_value = "";

    static ConfigDAO dao= new ConfigDAO();
    static{
        init();
    }
 
    public static void init(){
        init(budget, budget_value, configBudget);
        init(mysqlPath, mysqlPath_value, configMysqlPath);
    }
     
    private static void init(String key,String value,Config config) {
        config.setKey(key);
        config.setValue(value);
        Config tempC= dao.getByKey(key);
        if(tempC==null){
            Config c = new Config();
            c.setKey(key);
            c.setValue(value);
            dao.add(c);
        }
        else {
            config.setValue(tempC.getValue());
        }
    }
 
    public String get(String key) {
        Config config= dao.getByKey(key);
        return config.getValue();
    }
     
    public void update(String key, String value){
        Config config= dao.getByKey(key);
        config.setValue(value);
        dao.update(config);    
    }
     
    public int getIntBudget() {
        return Integer.parseInt(get(budget));
    }
     
}