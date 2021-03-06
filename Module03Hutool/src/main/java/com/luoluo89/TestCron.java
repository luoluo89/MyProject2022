package com.luoluo89;

import cn.hutool.core.date.DateUtil;
import cn.hutool.cron.CronUtil;
 
public class TestCron {
 
    public static void main(String[] args) {
        CronUtil.setMatchSecond(true);
        CronUtil.start();
 
        CronUtil.schedule("*/2 * * * * ?",new Runnable() {
            @Override
            public void run() {
                System.out.println(DateUtil.now()+ " 执行新任务");
            }
        });
    }
}