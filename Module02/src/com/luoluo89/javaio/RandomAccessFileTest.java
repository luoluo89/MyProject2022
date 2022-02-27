package com.luoluo89.javaio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class RandomAccessFileTest {

    public static void test() throws IOException {
        String fileName = "D:\\ideaWorspace\\MyProject202001\\src\\top\\hhhtgeekstudio\\javaio\\test.txt";
        RandomAccessFile ra = new RandomAccessFile(fileName, "rw");
        Random random = new Random(47);

        for(int i = 0; i<50; i++) {
            Double d = random.nextDouble();
            ra.writeBytes(d.toString());
            ra.writeBytes("\n");
            System.out.println(d);
        }
        ra.close();
    }

    public static void main(String[] args) throws IOException {
        test();
    }

}
