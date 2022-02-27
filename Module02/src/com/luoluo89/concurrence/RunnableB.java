package com.luoluo89.concurrence;

import java.util.concurrent.TimeUnit;

public class RunnableB implements Runnable {
    private static int num = 0;
    private final int id = num++;

    @Override
    public void run() {
        while (true){
            System.out.println("This is RunnableB running, id = " + id + ", TimeStamp is: " + System.currentTimeMillis());
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread th = new Thread(new RunnableB());
//        th.setDaemon(true);
        th.start();


    }
}
