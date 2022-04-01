package com.luoluo89;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.net.URL;

public class Test {
 
    public static void main(String[] args) throws Exception {
        String html = "<html><body><p>Hello HTML</p></body></html>";
        Document doc = Jsoup.parse(html);
        Elements as= doc.getElementsByTag("p");
        for (Element e : as) {
            System.out.println("基于Tag得到的 Element: " + e.text());
        }


        String html1 = "<html><body><p>Hello HTML</p></body></html>";
        Document doc1 = Jsoup.parse(html1);
        System.out.println("基于字符串方式得到的 Document:\r\n"+ doc1);
        File f = new File("E:\\ideaWorksapce\\MyProject202201\\Module04Jsoup\\resource\\a.html");
        if(f.exists()) {
            Document doc2 = Jsoup.parse(f,"utf-8");
            System.out.println("基于文件方式得到的 Document:\r\n"+ doc2);
        }
        String url = "http://www.baidu.com";
        Document doc3 = Jsoup.parse(new URL(url),5000); //超过5秒就报错
        System.out.println("基于URL方式得到的 Document:\r\n"+ doc3);
    }
}