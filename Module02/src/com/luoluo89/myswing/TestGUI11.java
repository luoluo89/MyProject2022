package com.luoluo89.myswing;

import javax.annotation.processing.Filer;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestGUI11 {
    public static void main(String[] args) {

        JFrame jFrame = new JFrame("LoL");
        jFrame.setSize(1024, 768);
        jFrame.setLocationRelativeTo(null);

        jFrame.setLayout(null);

        File folder = new File("D:\\02.code\\idea_workspace_03\\MyProject2022\\Module02\\src\\com\\luoluo89\\myswing");
        File[] fs=folder.listFiles();

        JTabbedPane jTabbedPane = new JTabbedPane();
        for (int i = 0; i < fs.length; i++) {
//            if(!fs[i].getName().endsWith(".java")){
//                continue;
//            }
            JTextArea textArea = new JTextArea();
            char[] content = new char[(int) fs[i].length()];
            try {
                FileReader fileReader = new FileReader(fs[i].getAbsoluteFile());
                fileReader.read(content);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            textArea.setText(new String(content));
            JScrollPane sp = new JScrollPane(textArea);
            jTabbedPane.add(textArea);
            jTabbedPane.setTitleAt(i, shortName(fs[i].getName()));
        }

        jFrame.setContentPane(jTabbedPane);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    private static String shortName(String name) {
        int length = 9;
        if(name.length()>length){
            return name.substring(0,length) + "...";
        }
        return name;

    }
}
