package com.luoluo89.thread;

public class TestThread8 {
    public static void main(String[] args) throws InterruptedException {

        final Object someObject = new Object();
        final Hero1 gareen = new Hero1();
        gareen.name = "盖伦";
        gareen.hp = 10000;
        int n = 10000;

        for (int i = 0; i < n; i++) {
            Thread t = new Thread() {
                public void run() {
                    //回血
                    gareen.recover();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("sleep error" + e);
                    }
                }
            };
            t.start();
        }

        for (int i = 0; i < n; i++) {
            Thread t = new Thread() {
                public void run() {
                    //掉血
                    gareen.hurt();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("sleep error" + e);
                    }
                }
            };
            t.start();
        }


        //因子线程数量过多，主线程需要等待所有子线程执行完毕，否则主线程关闭，数量不一致
        while (Thread.activeCount() > 2) {
            System.out.println("Thread.activeCount = "  +Thread.activeCount());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("sleep error" + e);
            }
        }

        System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量是 %.0f%n", n, n, gareen.hp);
    }
}
