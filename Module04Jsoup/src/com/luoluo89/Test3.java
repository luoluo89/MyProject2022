package com.luoluo89;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;

public class Test3 {
    public static void main(String[] args) throws Exception {

        File f = new File("E:\\ideaWorksapce\\MyProject202201\\Module04Jsoup\\resource\\c.html");
        if(!f.exists())
            return;

        Document doc = Jsoup.parse(f,"utf-8");

        Element e =doc.getElementById("d1");

        //获取属性
        System.out.println("获取属性 " + e.attr("id"));
        //获取所有属性
        System.out.println("获取所有属性 " + e.attributes());
        //获取id
        System.out.println("获取id " + e.id());
        //获取类名称
        System.out.println("获取类名称 " + e.className());
        //获取所有类名称
        System.out.println("获取所有类名称 " + e.classNames());
        //获取文本
        System.out.println("获取文本 " + e.text());
        //获取html
        System.out.println("获取html " + e.html());
        //获取外html
        System.out.println("获取外html " + e.outerHtml());
        //获取标签信息
        System.out.println("获取标签信息 " + e.tagName());
    }
}
