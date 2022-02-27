package com.luoluo89.thread;

/**
 * 线程等待和通知
 */
public class TestThread11 {
    public static void main(String[] args) {

        final Hero1 gareen = new Hero1();
        gareen.name = "盖伦";
        gareen.hp = 666;
        Thread t1 = new Thread(){
            public void run(){
                while(true){
                    gareen.hurt();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread(){
            public void run(){
                while(true){
                    gareen.recover();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();
    }
}
