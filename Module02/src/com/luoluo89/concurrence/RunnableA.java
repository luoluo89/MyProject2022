package com.luoluo89.concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunnableA implements Runnable{

    private static int num = 0;
    private final int id = num++;
    @Override
    public void run() {
        System.out.println("This is RunnableA running, id = " + id);
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 5 ; i++)
        {
            es.execute(new RunnableA());
        }
        es.shutdown();
    }
}
