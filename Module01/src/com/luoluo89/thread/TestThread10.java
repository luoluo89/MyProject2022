package com.luoluo89.thread;

/**
 * 线程死锁
 */
public class TestThread10 {
    public static void main(String[] args) {
        final Hero1 ahri = new Hero1();
        ahri.name = "鸣人";
        final Hero1 annie = new Hero1();
        annie.name = "小樱";
        final Hero1 sasiki = new Hero1();
        annie.name = "佐助";

        Thread t1 = new Thread(){
            public void run(){
                //占有九尾妖狐
                synchronized (ahri) {
                    System.out.println("t1 已占有鸣人");
                    try {
                        //停顿1000毫秒，另一个线程有足够的时间占有安妮
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("t1 试图占有小樱");
                    System.out.println("t1 等待中 。。。。");
                    synchronized (annie) {
                        System.out.println("do something");
                    }
                }
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            public void run(){
                //占有安妮
                synchronized (annie) {
                    System.out.println("t2 已占有小樱");
                    try {
                        //停顿1000毫秒，另一个线程有足够的时间占有暂用九尾妖狐
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("t2 试图占有佐助");
                    System.out.println("t2 等待中 。。。。");
                    synchronized (sasiki) {
                        System.out.println("do something");
                    }
                }
            }
        };
        t2.start();

        Thread t3 = new Thread(){
            public void run(){
                //占有安妮
                synchronized (sasiki) {
                    System.out.println("t3 已占有佐助");
                    try {
                        //停顿1000毫秒，另一个线程有足够的时间占有暂用九尾妖狐
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("t3 试图占有鸣人");
                    System.out.println("t3 等待中 。。。。");
                    synchronized (ahri) {
                        System.out.println("do something");
                    }
                }
            }
        };
        t3.start();
    }
}
