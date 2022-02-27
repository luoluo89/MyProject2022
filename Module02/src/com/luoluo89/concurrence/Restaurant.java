package com.luoluo89.concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 生产者消费者模式
 */

/**
 * 食物
 */
class Meal{
    private final int orderNum;

    Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    public String toString(){
        return "Meal " + orderNum;
    }
}

/**
 * 消费者类，生成多个消费者
 */
class Customer implements Runnable{
    private Restaurant restaurant;
    public Customer(Restaurant r)
    {
        this.restaurant = r;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                synchronized (this){
                    //如果食堂没饭，需要等待
                    while (restaurant.meal == null)
                        wait();
                }
                //生产者做好饭后，消费者就收到notify通知
                System.out.println("Wait Customer got " + restaurant.meal);
                //加锁，防止同时操作meal
                synchronized (restaurant.productor){
                    restaurant.meal = null;
                    //通知生产者，吃完了，没饭了
                    restaurant.productor.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Customer interrupted");
        }
    }
}

/**
 * 生产者类，做出多道菜
 */
class Productor implements Runnable{
    private Restaurant restaurant;
    private int count = 0;
    public Productor(Restaurant r){
        this.restaurant = r;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted())
            {
                synchronized (this){
                    while (restaurant.meal != null){
                        //生产者等待消费者吃饭
                        wait();
                    }
                    if(++count == 10){
                        System.out.println("Out of food, closing");
                        restaurant.executorService.shutdownNow();
                    }
                    System.out.println("Order up");
                    //加锁，防止同时操作meal
                    synchronized (restaurant.customer){
                        restaurant.meal = new Meal(count);
                        //通知消费者，饭做好了
                        restaurant.customer.notifyAll();
                    }
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Productor interrupted");
        }
    }
}

/**
 * 食堂包装类
 */
public class Restaurant {
    Meal meal;
    ExecutorService executorService = Executors.newCachedThreadPool();
    Customer customer = new Customer(this);
    Productor productor = new Productor(this);
    public Restaurant(){
        //只有一个生产者和一个消费者
        executorService.execute(productor);
        executorService.execute(customer);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}


