package com.luoluo89.consumer;

import java.util.LinkedList;

/**
 * 堆栈类
 * @param <T>
 */
public class MyStack<T> {
    LinkedList<T> linkedList = new LinkedList<T>();

    //出栈
    public synchronized T poll() {
        if (linkedList.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t = linkedList.poll();
//        System.out.println("出栈：" + t.toString());
        return t;
    }
    //进栈
    public synchronized void push(T t) {
        if (linkedList.size() >= 200) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        linkedList.add(t);
//        System.out.println("进栈：" + t.toString());
        this.notify();
    }
}
