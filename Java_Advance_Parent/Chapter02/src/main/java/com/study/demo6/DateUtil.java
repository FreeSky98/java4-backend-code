package com.study.demo6;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static void main(String[] args) {
        Date date = new Date();//获取现在的原始日期
        System.out.println("date = " + date);
        String format = "yyyy-MM-dd HH:mm:ss E";

        DateFormat df = new SimpleDateFormat(format);//创建日期格式化对象
        String formatted = df.format(date);//调用格式化对象方法，将日期传入后转化成字符串
        System.out.println("formatted = " + formatted);

        String reportDateStr = "2023/07/26 13:23:58";
        String patternStr = "yyyy/MM/dd HH:mm:ss";
        df = new SimpleDateFormat(patternStr);
        try {
            Date reportDate = df.parse(reportDateStr);//将String类型日期转换为Date类型
            System.out.println("reportDate = " + reportDate);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("日期格式错误@");
        }
    }
}
