package com.luoluo89.thread;

public class TestThread1 {
    public static void main(String[] args) {
        Thread t1= new Thread(){
            public void run(){
                int seconds =0;
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩了LOL %d 秒%n", seconds++);
                    for (int i = 0; i < 10; i++) {
                        System.out.println("");
                    }
                }
            }
        };
        t1.start();
    }
}
