package com.luoluo89.lock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 堆栈类
 *
 * @param <T>
 */
public class MyStackLock<T> {
    LinkedList<T> linkedList = new LinkedList<T>();
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    //出栈
    public T poll() {
        try {
            lock.lock();
            while (linkedList.size() == 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            condition.signalAll();
            T t = linkedList.poll();
            System.out.println("出栈：" + t.toString());
            return t;
        } finally {
            lock.unlock();
        }
    }

    //进栈
    public void push(T t) {
        try {
            lock.lock();
            while (linkedList.size() >= 200) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            condition.signalAll();
            linkedList.add(t);
            System.out.println("进栈：" + t.toString());
        } finally {
            lock.unlock();
        }
    }
}
