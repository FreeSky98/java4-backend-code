package com.study.mathutil;
import cn.hutool.core.util.NumberUtil;

import java.util.Random;

import static java.lang.Math.*;
public class MathUtil {
    public static void main(String[] args) {
        //绝对值abs
        System.out.println("abs(4) = " + abs(4));
        System.out.println("abs(0) = " + abs(0));
        System.out.println("abs(-4) = " + abs(-4));

        System.out.println("abs(Integer.MAX_VALUE) = " + abs(Integer.MAX_VALUE));
        System.out.println("abs(Integer.MIN_VALUE) = " + abs(Integer.MIN_VALUE));

        //向上取整ceil
        final long totalRows = 106;//总记录106条
        final int pageSize = 10;//每页显示10条
        int pageCount = (int) Math.ceil(totalRows * 1.0 / pageSize);//计算总页数
        System.out.println("总记录  totalRows = " + totalRows);
        System.out.println("每页显示  pageSize = " + pageSize);
        System.out.println("总页数  pageCount = " + pageCount);

        //向下取整floor
        System.out.println("floor(2.3) = " + floor(2.3));
        System.out.println("floor(0) = " + floor(0.0));
        System.out.println("floor(-2.3) = " + floor(-2.3));

        //求幂pow
        System.out.println("pow(2,10) = " + pow(2, 10));


        //4.sqrt(double a) 求a的平方根
        System.out.println("Math.sqrt(1) = " + sqrt(1));//1.0
        System.out.println("Math.sqrt(2) = " + NumberUtil.roundStr(sqrt(2),3));//1.41
        System.out.println("Math.sqrt(3) = " +  NumberUtil.roundStr(sqrt(3),3));//1.73
        System.out.println("Math.sqrt(4) = " +  NumberUtil.roundStr(sqrt(4),3));//2.0
        System.out.println("Math.sqrt(5) = " +  NumberUtil.roundStr(sqrt(5),3)); //2.23
        System.out.println("Math.sqrt(6) = " +  NumberUtil.roundStr(sqrt(6),3));//2.44
        System.out.println("Math.sqrt(7) = " +  NumberUtil.roundStr(sqrt(7),3));//2.64
        System.out.println("Math.sqrt(8) = " +  NumberUtil.roundStr(sqrt(8),3));//2.828
        System.out.println("Math.sqrt(9) = " +  NumberUtil.roundStr(sqrt(9),3));//3.0

        //NumberUtil.roundStr 方法主要封装String.format方法,舍弃方式采用四舍五入。
        System.out.println(NumberUtil.roundStr(2.565,2)); // NumberUtil.roundStr(v,scale)

        //最大值最小值
        int a = 5 ,b = 3,c = 7,max,min;
        int temp = max(a,b);
        max = max(temp,c);
        System.out.println("最大值 = " + max);

        temp = min(a,b);
        min = min(temp,c);
        System.out.println("最小值 = " + min);

        long seed = System.currentTimeMillis();//获取系统当前时间毫秒数
        Random random = new Random(seed);//以系统时间为种子
        Random random2 = new Random();//默认以系统时间为种子

        //随机生成指定范围的整数[20,80]
        int maxVal = 80,minVal = 20;
        int randomNumber,count = 0;
        for (int i = 0; i < 20; i++) {
            randomNumber = (int) (random() * (80 - 20 + 1) + 20);
            count++;
            if ((count++) % 5 == 0) {
                System.out.println();
            }
            System.out.print(randomNumber + "\t");
        }
    }
}

