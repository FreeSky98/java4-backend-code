package com.study.demo6;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarUtil {
    public static void main(String[] args) {
        //Calendar是一个抽象类，需要一个getInstance(Locale.XXX国家名)方法来获取
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        int millis = calendar.get(Calendar.MILLISECOND);
        int week = calendar.get(Calendar.DAY_OF_WEEK);//1 == "星期日"
        System.out.println(year + "年" + month + "月" + day + "日" + " " +  hour + ":" + minute+":" + second + "." +millis + ",星期" + (week-1));


        // Date类型和Calendar类型相互转换
        // 1. 将Calendar类型转换为Date类型
        Calendar cal2 = Calendar.getInstance();
        Date now = cal2.getTime();

        // 2. 将Date类型转换为Calendar类型
        Date today = new Date();
        Calendar cal3 = Calendar.getInstance();
        cal3.setTime(today);
    }
}
