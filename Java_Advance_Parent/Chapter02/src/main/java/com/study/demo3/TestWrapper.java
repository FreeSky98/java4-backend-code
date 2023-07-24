package com.study.demo3;

public class TestWrapper {
    public static void main(String[] args) {
        String str = "123";

        int num1 = Integer.parseInt(str);//parseXXX将字符串转成对应类型
//        int num2 = Integer.valueOf(str);

        System.out.println("num1 = " + num1);
//        System.out.println("num2 = " + num2);

        //1.基本数据类型转换为包装类
        int a = 314;
        Integer b = a;//装箱
//        Integer b = Integer.valueOf(a);

        boolean aRet = true;
        Boolean bRet = aRet;
//        Boolean bRet = Boolean.valueOf(aRet);

        //2.包装类转换为基本数据类型
        Integer int1 = 456;
        int i = int1;
//        int i = int1.intValue();

        //3.包装类和String类型转换
        Integer integer = 123;
//        String intToStr = integer + "";
        String intToStr = Integer.toString(integer);
        System.out.println("intToStr = " + intToStr);

        String str2 = "67";
        int strToInt = Integer.parseInt(str2);
        System.out.println("strToInt = " + strToInt);
    }
}
