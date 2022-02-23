package com.luoluo89.consumer;

public class TestThread {
    public static void main(String[] args) {
        MyStack stack = new MyStack<Character>();
        new Consumer(stack).start();
        new Producer(stack).start();
    }
}
