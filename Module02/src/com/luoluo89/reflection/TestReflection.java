package com.luoluo89.reflection;

import com.luoluo89.socket.Client;

public class TestReflection {
 
    public static void main(String[] args) {
            String className = "com.luoluo89.socket.Client";
            try {
                Class pClass1=Class.forName(className);
                Class pClass2= Client.class;
                Class pClass3=new Client().getClass();
                System.out.println(pClass1==pClass2);
                System.out.println(pClass1==pClass3);
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
}