package com.luoluo89.thread;

public class TestThread4 {
    public static void main(String[] args) {
        Hero3 dongdongbo  = new Hero3();
        Thread thread1 = new Thread(){
            @Override
            public void run() {

                while (true){
                    dongdongbo.bodongquan();
                    try {
                        this.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (dongdongbo.getBodongquan()> 3)
                    {
                        try {
                            dongdongbo.setEnergy(0);
                            while (dongdongbo.getEnergy()<5){
                                dongdongbo.chongneng();
                                try {
                                    this.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            dongdongbo.setBodongquan(1);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        thread1.run();



    }
}
