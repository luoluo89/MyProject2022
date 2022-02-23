package com.luoluo89.consumer;

public class Producer extends Thread {
    private MyStack<Character> stack;

    public Producer(MyStack<Character> stack){
        this.stack = stack;
    }

    @Override
    public void run() {
        while (true){
            this.stack.push(randomChar());
            System.out.println("stack" + stack);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public char randomChar(){
        return (char) (Math.random()*('Z'+1-'A') + 'A');
    }
}
