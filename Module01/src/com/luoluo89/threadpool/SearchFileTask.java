package com.luoluo89.threadpool;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SearchFileTask implements Runnable {
    private File file;
    private String search;
    public SearchFileTask(File file,String search) {
        this.file = file;
        this.search= search;
    }

    public void run(){

        String fileContent = readFileConent(file);
        if(fileContent.contains(search)){
            System.out.printf( "线程: %s 找到子目标字符串%s,在文件:%s%n",Thread.currentThread().getName(), search,file);
        }
    }

    public String readFileConent(File file){
        try (FileReader fr = new FileReader(file)) {
            char[] all = new char[(int) file.length()];
            fr.read(all);
            return new String(all);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
