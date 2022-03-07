package com.luoluo89.threadpool;

import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 */
public class TestThread13 {
    static ThreadPool pool= new ThreadPool();
    public static void search(File file, String search) {

        if (file.isFile()) {
            if(file.getName().toLowerCase().endsWith(".txt")){
                SearchFileTask task = new SearchFileTask(file, search);
                pool.add(task);
            }
        }
        if (file.isDirectory()) {
            File[] fs = file.listFiles();
            for (File f : fs) {
                search(f, search);
            }
        }
    }

    public static void main(String[] args) {
        File folder =new File("D:\\02.code");
        search(folder,"妖怪");
    }
}
