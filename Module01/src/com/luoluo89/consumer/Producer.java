package com.luoluo89.consumer;

import java.util.Date;

public class Producer extends Thread {
    private String name;
    private MyStack<Long> stack;

    public Producer(String name, MyStack<Long> stack){
        this.name = name;
        this.stack = stack;
    }

    @Override
    public void run() {
        while (true){
            long c = ProduceUtil.produce();
            this.stack.push(c);
            System.out.println(name + "生产了：" + c);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
