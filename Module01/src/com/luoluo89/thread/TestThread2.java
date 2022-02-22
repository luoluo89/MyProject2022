package com.luoluo89.thread;

/**
 * 设置线程优先级
 */
public class TestThread2 {
    public static void main(String[] args) {
        final Hero2 gareen = new Hero2();
        gareen.name = "盖伦";
        gareen.hp = 3000;
        gareen.damage = 1;

        final Hero2 teemo = new Hero2();
        teemo.name = "提莫";
        teemo.hp = 3000;
        teemo.damage = 1;

        final Hero2 bh = new Hero2();
        bh.name = "赏金猎人";
        bh.hp = 3000;
        bh.damage = 1;

        final Hero2 leesin = new Hero2();
        leesin.name = "盲僧";
        leesin.hp = 3000;
        leesin.damage = 1;

        Thread t1= new Thread(){
            public void run(){

                while(!teemo.isDead()){
                    gareen.attackHero(teemo);
                }
            }
        };

        Thread t2= new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    bh.attackHero(leesin);
                }
            }
        };

        t2.setPriority(Thread.MIN_PRIORITY);
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
