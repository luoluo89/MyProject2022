package com.luoluo89;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class TestHutool {
    public static void main(String[] args) {
        String str = "2022-03-16 16:38:00";
        Date date = DateUtil.parse(str);
        System.out.println(date);
    }
}
