package com.luoluo89.hutubill.service;

import com.luoluo89.hutubill.dao.RecordDAO;
import com.luoluo89.hutubill.entity.Record;
import com.luoluo89.hutubill.page.SpendPage;
import com.luoluo89.hutubill.util.DateUtil;

import java.util.Calendar;
import java.util.List;

public class SpendService {

    static RecordDAO dao = new RecordDAO();

    public int listToday() {
        int today = 0;
        List<Record> recordList = dao.listToday();
        for (Record r : recordList) {
            today = today + r.getSpend();
        }
        return today;
    }

    public int listThisMonth() {
        int thisMonth = 0;
        List<Record> recordList = dao.listThisMonth();
        for (Record r : recordList) {
            thisMonth = thisMonth + r.getSpend();
        }
        return thisMonth;
    }

    public SpendPage getSpendPage() {

        //本月消费
        int monthSpend = 0;
        //今日消费
        int todaySpend = 0;
        //日均消费
        int avgSpendPerDay = 0;
        //本月剩余
        int monthAvailable = 0;
        //日均可用
        int dayAvgAvailable = 0;
        //距离月末
        int monthLeftDay = 0;
        //使用比例
        int usagePercentage = 0;

        int budget = new ConfigService().getIntBudget();

        monthSpend = listThisMonth();
        todaySpend = listToday();
        avgSpendPerDay = monthSpend / (DateUtil.thisMonthTotalDay()- DateUtil.thisMonthLeftDay());
        monthAvailable = budget - monthSpend;
        monthLeftDay = DateUtil.thisMonthLeftDay();
        dayAvgAvailable = monthAvailable / monthLeftDay;
        usagePercentage = (monthSpend  * 100) / budget;
        System.out.println(usagePercentage);

        SpendPage spendPage = new SpendPage(monthSpend, todaySpend, avgSpendPerDay, monthAvailable, dayAvgAvailable, monthLeftDay, (int)usagePercentage);

        return spendPage;
    }

}
