package com.luoluo89.javaio;

public class TextFileTest {

    public static void main(String[] args) {
        String text = TextFileUtil.fileRead("D:\\ideaWorspace\\MyProject202001\\src\\top\\hhhtgeekstudio\\javaio\\TextFileTest.java");
        System.out.println(text);
        TextFileUtil.fileWrite("D:\\ideaWorspace\\MyProject202001\\src\\top\\hhhtgeekstudio\\javaio\\TextFileTest.txt", text);

    }
}
