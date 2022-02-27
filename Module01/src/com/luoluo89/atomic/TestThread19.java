package com.luoluo89.atomic;

public class TestThread19 {
    public static void main(String[] args) throws InterruptedException {
        final Hero4 gareen = new Hero4();
        gareen.name = "盖伦";
        gareen.hp.set(1);
        gareen.damage = 1;

        //hp的原子特性，会使得每个线程顺序执行
        for (int i = 0; i < 1000; i++) {
            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    try {
                        gareen.hurt();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread1.run();
        }

        //hp的原子特性，会使得每个线程顺序执行
        for (int i = 0; i < 1000; i++) {
            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    try {
                        gareen.recover();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread2.run();
        }

        //等待所有子线程跑完
        Thread.sleep(5000);
    }
}
