package com.luoluo89.thread;

/**
 * 设置线程加入主进程
 */
public class MainThread {
    public static void main(String[] args) {

        final Hero1 gareen = new Hero1();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        final Hero1 teemo = new Hero1();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        final Hero1 bh = new Hero1();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        final Hero1 leesin = new Hero1();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

        Thread t1= new Thread(){
            public void run(){
                while(!teemo.isDead()){
                    gareen.attackHero(teemo);
                }
            }
        };

        t1.start();

        //代码执行到这里，一直是main线程在运行
        try {
            //t1线程加入到main线程中来，只有t1线程运行结束，才会继续往下走
            t1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Thread t2= new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    bh.attackHero(leesin);
                }
            }
        };
        //会观察到盖伦把提莫杀掉后，才运行t2线程
        t2.start();

    }
}
