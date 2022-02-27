package com.luoluo89.concurrence;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Pair {
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            super("Pair not equal: " + Pair.this);
        }
    }

    public void checkState() {
        if (x != y) throw new PairValuesNotEqualException();
    }
}

abstract class PairManager {
    //原子类
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());
    public synchronized Pair getPair(){
        return new Pair(p.getX(),p.getY());
    }
    protected void stor(Pair p){
        try{
            TimeUnit.MILLISECONDS.sleep(500);
        }catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public abstract void incerement();
}

class PairManager1 extends PairManager{

    @Override
    public synchronized void incerement() {
        p.incrementX();
        p.incrementY();
        stor(getPair());
    }
}

class PairManager2 extends PairManager{

    @Override
    public void incerement() {
        Pair temp;
        synchronized (this){
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        stor(temp);
    }
}

class PairRunner1 implements Runnable{

    private PairManager pm;
    public PairRunner1(PairManager p){
        this.pm = p;
    }
    @Override
    public void run() {
        while(true)
            pm.incerement();
    }
    public String toString(){
        return "Pair: " + pm.getPair() + ", checkCounter = " + pm.checkCounter.get();
    }
}

class PairRunner2 implements Runnable{
    private PairManager pm;
    public PairRunner2(PairManager p){
        this.pm = p;
    }
    @Override
    public void run() {
        while(true){
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
    public String toString(){
        return "Pair: " + pm.getPair() + ", checkCounter = " + pm.checkCounter.get();
    }
}

public class CriticalSection {
    static void testApproaches(PairManager pm1, PairManager pm2) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        PairRunner1 pr11 = new PairRunner1(pm1);
        PairRunner1 pr12 = new PairRunner1(pm2);
//        PairRunner2 pr21 = new PairRunner2(pm1);
//        PairRunner2 pr22 = new PairRunner2(pm2);

        es.execute(pr11);
        es.execute(pr12);
//        es.execute(pr21);
//        es.execute(pr22);

        TimeUnit.MILLISECONDS.sleep(500);

        System.out.println("pr11 = " + pr11 + "\npr12 = "+ pr12);
        System.exit(0);
    }

    public static void main(String[] args) throws InterruptedException {
        PairManager pman1 = new PairManager1();
        PairManager pman2 = new PairManager2();
        testApproaches(pman1, pman2);
        }
    }
