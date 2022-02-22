package com.luoluo89.thread;

public class TestThread5 {
    public String name;
    public float hp;

    public TestThread5() {

    }

    public TestThread5(String name) {
        this.name = name;
    }

    public int damage;

    public boolean isDead() {
        return 0 >= hp ? true : false;
    }

    int totalTime = 3;

    public void adugen() {
        while (true) {
            for (int i = 0; i < totalTime; i++) {
                System.out.printf("波动拳第%d发%n", i + 1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            System.out.println("开始为时5秒的充能");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        TestThread5 h = new TestThread5();
        h.name = "红仔";

        h.adugen();
    }

}
