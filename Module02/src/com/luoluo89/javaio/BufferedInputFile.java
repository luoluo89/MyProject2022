package com.luoluo89.javaio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {

    public static void read(String fileName) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(fileName));
        StringBuffer sb = new StringBuffer();
        String str = bf.readLine();
        while (null != str) {
            sb.append(str);
            sb.append("\n");
            str = bf.readLine();
        }
        System.out.println(sb.toString());
        bf.close();
    }

    public static void main(String[] args) throws IOException {
        read("D:\\ideaWorspace\\MyProject202001\\src\\top\\hhhtgeekstudio\\javaio\\BufferedInputFile.java");
    }
}
