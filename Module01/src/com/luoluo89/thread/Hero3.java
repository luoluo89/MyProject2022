package com.luoluo89.thread;

public class Hero3 {
    private int bodongquan;
    private int energy;

    public Hero3()
    {
        bodongquan = 1;
        energy = 0;
    }

    public void bodongquan()
    {
        System.out.println("波动拳第" + bodongquan++ + "发");

    }

    public void chongneng()
    {
        System.out.println("充能" + ++energy + "秒");
    }

    public int getBodongquan() {
        return bodongquan;
    }

    public void setBodongquan(int bodongquan) {
        this.bodongquan = bodongquan;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
