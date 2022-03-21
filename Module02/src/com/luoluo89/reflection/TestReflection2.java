package com.luoluo89.reflection;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflection2 {
    public static void main(String[] args) throws InterruptedException {
        File f = new File("E:/project/j2se/hero.config");

        try (FileReader fr = new FileReader(f)) {
            String fileContent = null;
            char[] all = new char[(int) f.length()];
            fr.read(all);
            fileContent = new String(all);
            String[] cs = fileContent.split("\r\n");
            String hero1className = cs[0];
            String hero1Name = cs[1];
            String hero2className = cs[2];
            String hero2Name = cs[3];

            //根据反射，获取hero1，并且给hero1的name字段赋值
            Class hero1Class = Class.forName(hero1className);
            Constructor hero1Constructor = hero1Class.getConstructor();
            Object hero1 = hero1Constructor.newInstance();
            Field hero1NameField = hero1Class.getField("name");
            hero1NameField.set(hero1, hero1Name);

            //根据反射，获取hero2,并且给hero2的name字段赋值
            Class hero2Class = Class.forName(hero2className);
            Constructor hero2Constructor = hero2Class.getConstructor();
            Object hero2 = hero2Constructor.newInstance();
            Field hero2NameField = hero2Class.getField("name");
            hero2NameField.set(hero2, hero2Name);

            //根据反射，获取attackHero方法，并且调用hero1的这个方法，参数是hero2
            Method attackHeroMethod = hero1Class.getMethod("attackHero", Hero.class);
            attackHeroMethod.invoke(hero1, hero2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
