package com.luoluo89.thread;

/**
 * 守护线程
 */
public class TestThread3 {
    public static void main(String[] args) {

        Thread t1= new Thread(){
            public void run(){
                int seconds =0;

                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩了LOL %d 秒%n", seconds++);

                }
            }
        };
        //t1为守护线程，t2结束后，t1自动结束
        t1.setDaemon(true);
        t1.start();


        Thread t2= new Thread(){
            public void run(){
                int seconds =0;

                while(seconds < 10){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩了吃鸡 %d 秒%n", seconds++);

                }
            }
        };
        t2.start();

    }
}
