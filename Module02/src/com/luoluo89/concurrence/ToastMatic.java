package com.luoluo89.concurrence;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * BlockingQuene的示例，通过队列实现同步功能
 */

class Toast{
    //吐司制作的三种状态，原味吐司，黄油吐司，烤吐司
    public enum Status{DRY, BUTTERED, JAMMED}

    public Status status = Status.DRY;
    private final int id;
    public Toast(int idn){id = idn;}
    public void butter(){status = Status.BUTTERED;}
    public void jam(){status = Status.JAMMED;}
    public Status getStatus(){return status;}
    public int getId(){return id;}
    public String toString(){
        return "Toast " + id + ": " + status;
    }
}

/**
 * 继承了同步队列，不需要通过其他加锁的方式，可以避免多线程同时访问
 */
class ToastQueue extends LinkedBlockingQueue<Toast>{}

/**
 * 制作原味吐司的进程
 */
class Toaster implements Runnable{
    private ToastQueue dryQueue;
    private int count = 0;
    private Random rand = new Random(47);
    public Toaster(ToastQueue dryQueue){
        this.dryQueue = dryQueue;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
                Toast t = new Toast(count++);
                System.out.println(t.toString());
                dryQueue.put(t);
                System.out.println("dryQueue.size = " + dryQueue.size());
            }
        } catch (InterruptedException e) {
            System.out.println("Toaster interrupted");
        }
        System.out.println("Toaster off");
    }
}

/**
 * 给吐司抹黄油的进程
 */
class Butterer implements Runnable{
    private ToastQueue dryQueue, butteredQueue;

    public Butterer(ToastQueue dryQueue, ToastQueue butteredQueue) {
        this.dryQueue = dryQueue;
        this.butteredQueue = butteredQueue;
    }


    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                Toast t = dryQueue.take();
                System.out.println("dryQueue.size = " + dryQueue.size());
                t.butter();
                System.out.println(t.toString());
                butteredQueue.put(t);
                System.out.println("butteredQueue.size = " + butteredQueue.size());
            }
        } catch (InterruptedException e) {
            System.out.println("Butterer interrupted");
        }
        System.out.println("Butterer off");
    }
}

/**
 * 烤吐司的进程
 */
class Jammer implements Runnable{
    private ToastQueue butteredQueue, finishedQueue;

    public Jammer(ToastQueue butteredQueue, ToastQueue finishedQueue) {
        this.butteredQueue = butteredQueue;
        this.finishedQueue = finishedQueue;
    }


    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                Toast t = butteredQueue.take();
                System.out.println("butteredQueue.size = " + butteredQueue.size());
                t.jam();
                System.out.println(t.toString());
                finishedQueue.put(t);
                System.out.println("finishedQueue.size = " + finishedQueue.size());
            }
        } catch (InterruptedException e) {
            System.out.println("Jammer interrupted");
        }
        System.out.println("Jammer off");
    }
}

/**
 * 吃吐司的进程
 */
class Eater implements Runnable{
    private ToastQueue finishedQueue;
    private int counter = 0;
    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                Toast t = finishedQueue.take();
                System.out.println("finishedQueue.size = " + finishedQueue.size());
                if(t.getId() != counter++ || t.getStatus() != Toast.Status.JAMMED){
                    System.out.println(">>>>>  Error: " + t.toString());
                    System.exit(1);
                }
                else {
                    System.out.println("Chomp! " + t.toString());
//                    TimeUnit.SECONDS.sleep(2);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Eater interrupted");
        }
        System.out.println("Eater off");
    }
}
public class ToastMatic {
    public static void main(String[] args) throws InterruptedException {
        //三个同步队列，分别放原味吐司，黄油吐司，烤吐司
        ToastQueue dryQueue = new ToastQueue();
        ToastQueue butteredQueue = new ToastQueue();
        ToastQueue finishedQueue = new ToastQueue();
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new Toaster(dryQueue));
        es.execute(new Butterer(dryQueue, butteredQueue));
        es.execute(new Jammer(butteredQueue, finishedQueue));
        es.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(2);
        es.shutdownNow();
    }
}
