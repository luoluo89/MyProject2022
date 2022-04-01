package com.luoluo89;
import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test5 {
    static Document doc;
    public static void main(String[] args) throws Exception {

        File f = new File("E:\\ideaWorksapce\\MyProject202201\\Module04Jsoup\\resource\\a.html");
        if(!f.exists())
            return;

        doc = Jsoup.parse(f,"utf-8");

        System.out.println(doc);

        Element e = doc.select("p").first();
        e.attr("class", "class1");

        e.appendText(" Hello JSoup");
        System.out.println();
        System.out.println(doc);

    }
}
