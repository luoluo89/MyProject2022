package com.luoluo89.javaio;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStreamTest {

    public static void read (String fileName) throws IOException {
        DataInputStream ds = new DataInputStream(new FileInputStream(fileName));
        while (ds.available() != 0)
        {
            System.out.print((char)ds.readByte());
        }
        ds.close();
    }

    public static void main(String[] args) throws IOException {
        read("D:\\ideaWorspace\\MyProject202001\\src\\top\\hhhtgeekstudio\\javaio\\InputStreamTest.java");
    }
}
