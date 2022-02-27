package com.luoluo89.concurrence;

import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 银行出纳员仿真
 */

class BankCustomer {
    private final int serviceTime;

    BankCustomer(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public String toString() {
        return "[" + serviceTime + "]";
    }
}

/**
 * 模拟客户排队场景
 */
class CustomerLine extends ArrayBlockingQueue<BankCustomer> {
    public CustomerLine(int maxLineSize) {
        super(maxLineSize);
    }

    public String toString() {
        if (this.size() == 0) {
            return "[Empty]";
        }
        StringBuilder result = new StringBuilder();
        for (BankCustomer customer : this) {
            result.append(customer);
        }
        return result.toString();
    }
}

/**
 * 模拟客户来银行办理业务，随机产生多个客户，每个客户需要不同的办理时间
 */
class CustomerGenerator implements Runnable {
    private CustomerLine customers;
    private static Random rand = new Random(66);

    public CustomerGenerator(CustomerLine cl) {
        customers = cl;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //不停的生成新的客户
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
                customers.put(new BankCustomer(rand.nextInt(1000)));
            }
        } catch (InterruptedException e) {
            System.out.println("CustomerGenerator interrrupted.");
        }
        System.out.println("CustomerGenerator terminating.");
    }
}

/**
 * 模拟银行出纳员，对每位客户进行服务
 */
class Teller implements Runnable, Comparable<Teller> {

    private static int counter = 0;
    private final int id = counter++;
    private int customerSserved = 0;
    private CustomerLine customers;
    //标志位，true表示正在办理业务
    private boolean servingCustomerLine = true;

    public Teller(CustomerLine cl) {
        this.customers = cl;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            BankCustomer customer = null;
            try {
                //从排队的客户中叫第一个
                customer = customers.take();
                TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
                synchronized (this) {
                    customerSserved++;
                    while (!servingCustomerLine) {
                        //正在处理其他事情，请客户等待
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(this + " interrupted");
            }
        }
        System.out.println(this + " terminating");
    }

    /**
     * 处理其他业务
     */
    public synchronized void doSomethingElse(){
        customerSserved = 0;
        servingCustomerLine = false;
    }

    /**
     * 处理客户业务
     */
    public synchronized void serveCustomerLine(){
        assert !servingCustomerLine: "already serving: " + this;
        servingCustomerLine = true;
        notifyAll();
    }

    public String toString(){
        return "Teller " + id + " ";
    }
    public String shotString(){
        return "T " + id;
    }

    @Override
    public synchronized int compareTo (Teller o){
        return customerSserved < o.customerSserved ? -1 : (customerSserved == o.customerSserved ? 0 : 1);
    }
}

/**
 * 出纳员管理类
 */
class TellerManager implements Runnable{
    private ExecutorService exec;
    private CustomerLine customers;
    private PriorityQueue<Teller> workingTellers = new PriorityQueue<Teller>();
    private Queue<Teller> doSomethingElseTellers = new LinkedList<Teller>();
    private int adjustmentPeriod;
    private static Random rand = new Random(66);
    public TellerManager(ExecutorService e, CustomerLine customers, int adjustmentPeriod){
        this.exec = e;
        this.customers = customers;
        this.adjustmentPeriod = adjustmentPeriod;
        //初始只有一个出纳员
        Teller teller = new Teller(customers);
        exec.execute(teller);
        workingTellers.add(teller);
    }

    //当排队客户数量较多时，增加出纳员数量
    public void adjustTellerNumber(){
        //等待客户比出纳员多一倍以上时
        if(customers.size() / workingTellers.size() >2){
            //如果有正在办理其他业务的出纳员，则让他办理客户业务
            if(doSomethingElseTellers.size() > 0){
                Teller teller = doSomethingElseTellers.remove();
                teller.serveCustomerLine();
                workingTellers.offer(teller);
                return;
            }
            //新增一个出纳
            Teller teller = new Teller(customers);
            exec.execute(teller);
            workingTellers.add(teller);
            return;
        }

        //如果等待客户数量没有那么多，则让出纳员办理别的业务
        if(workingTellers.size() > 1 && customers.size() / workingTellers.size() < 2){
            reassignOneTeller();
        }
        //如果等待客户为0，让出纳员办理别的业务
        if(customers.size() == 0)
        {
            while (workingTellers.size() > 1){
                reassignOneTeller();
            }
        }
    }

    /**
     * 出纳员处理完客户业务后处理其他业务
     */
    private void reassignOneTeller(){
        Teller teller = workingTellers.poll();
        teller.doSomethingElse();
        doSomethingElseTellers.offer(teller);
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                adjustTellerNumber();
                System.out.println(customers + " { ");
                for (Teller teller : workingTellers)
                    System.out.println(teller.shotString() + " ");
                System.out.println("}");
            }
        }catch (InterruptedException e){
            System.out.println(this + "interrupted");
        }
        System.out.println(this + "terminating");
    }
    public String toString(){
        return "TellerManager ";
    }
}

public class BankTellerSimulation {
    static final int MAX_LINE_SIZE = 50;
    static final int ADJUSTMENT_PERIOD = 1000;

    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        //最多来50个客户
        CustomerLine customers = new CustomerLine(MAX_LINE_SIZE);
        exec.execute(new CustomerGenerator(customers));
        exec.execute(new TellerManager(exec, customers, ADJUSTMENT_PERIOD));
        if(args.length > 0){
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
        }
        else{
            System.out.println("press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }

    }
