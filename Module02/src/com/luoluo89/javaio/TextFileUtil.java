package com.luoluo89.javaio;

import java.io.*;
import java.util.ArrayList;

public class TextFileUtil extends ArrayList<String> {

    public static String fileRead(String fileName) {
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String str = bf.readLine();
                while (str != null) {
                    sb.append(str);
                    sb.append("\n");
                    str = bf.readLine();
                }
            } finally {
                bf.close();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return sb.toString();
    }

    public static void fileWrite(String fileName, String text) {

        try {
            PrintWriter pw = new PrintWriter(new File(fileName).getAbsoluteFile());
            try
            {
                pw.print(text);
            }
            finally {
                pw.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        }
    }

}
