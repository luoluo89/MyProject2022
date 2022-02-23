package com.luoluo89.consumer;

/**
 * 消费者
 */
public class Consumer extends Thread {
    private MyStack<Character> stack;

    public Consumer(MyStack<Character> stack){
        this.stack = stack;
    }

    @Override
    public void run() {
        while (true){
            Character stack = this.stack.poll();
            System.out.println("stack" + stack);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
