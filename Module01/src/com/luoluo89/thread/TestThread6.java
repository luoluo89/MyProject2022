package com.luoluo89.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 1. 生成一个长度是3的随机字符串，把这个字符串当作 密码
 * 2. 创建一个破解线程，使用穷举法，匹配这个密码
 * 3. 创建一个日志线程，打印都用过哪些字符串去匹配，这个日志线程设计为守护线程
 * 提示： 破解线程把穷举法生成的可能密码放在一个容器中，日志线程不断的从这个容器中拿出可能密码，并打印出来。 如果发现容器是空的，就休息1秒，如果发现不是空的，就不停的取出，并打印。
 */
public class TestThread6 {

    public static void main(String[] args) {
        String passwd = String.valueOf(new Random().nextInt(999));
        System.out.println("密碼是：" + passwd);
        final List<String> container = new ArrayList<>();

        //破解线程
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                String key = "";
                for (int i = 0; i < 1000; i++) {
                    if (i < 10){
                        key = "00" + i;
                    }
                    else{
                        if(i < 100){
                            key = "0" + i;
                        }
                        else{
                            key = String.valueOf(i);
                        }
                    }
                    container.add(key);
                }
            }
        };
        thread1.run();

        //日志线程
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                while (true){
                    if(container.isEmpty()){
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        String key = container.get(0);
                        container.remove(0);
                        if (key.equals(passwd))
                        {
                            System.out.println("密码匹配成功，密码为：" + key);
                            return;
                        }
                        else{
                            System.out.println("尝试使用" + key + "破解");
                        }
                    }
                }
            }
        };
//        thread2.setDaemon(true);
        thread2.run();
    }
}
