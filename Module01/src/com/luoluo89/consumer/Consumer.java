package com.luoluo89.consumer;

/**
 * 消费者
 */
public class Consumer extends Thread {
    private String name;
    private MyStack<Long> stack;

    public Consumer(String name, MyStack<Long> stack){
        this.name = name;
        this.stack = stack;
    }

    @Override
    public void run() {
        while (true){
            Long ca = this.stack.poll();
            System.out.println(name + "消费了：" + ca);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
