package com.luoluo89.consumer;

public class TestThread12 {
    public static void main(String[] args) {
        MyStack stack = new MyStack<String>();

        new Consumer("张三", stack).start();
        new Consumer("李四", stack).start();
        new Producer("工厂1", stack).start();
        new Producer("工厂2", stack).start();
        new Producer("工厂3", stack).start();
        new Producer("工厂4",stack).start();
    }
}
