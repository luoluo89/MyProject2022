package com.luoluo89.thread;

/**
 * 英雄有可以放一个技能叫做: 波动拳-a du gen。
 * 每隔一秒钟，可以发一次，但是只能连续发3次。
 * 发完3次之后，需要充能5秒钟，充满，再继续发。
 */
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
