package com.luoluo89.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 通过AtomicInteger的原子特性，实现安全的线程
 */
public class Hero4 {
    public String name;
    public AtomicInteger hp = new AtomicInteger();
    public int damage;

    public boolean isDead() {
        return 0 >= hp.intValue() ? true : false;
    }

    //回血
    public void recover() throws InterruptedException {
        hp.incrementAndGet();
        System.out.printf("%s 回血1点,增加血后，%s的血量是%d", name, name, hp.intValue());
        System.out.println("\r");
    }

    //掉血
    public void hurt() throws InterruptedException {
        hp.decrementAndGet();
        System.out.printf("%s 减血1点,减少血后，%s的血量是%d", name, name, hp.intValue());
        System.out.println("\r");
    }
}
