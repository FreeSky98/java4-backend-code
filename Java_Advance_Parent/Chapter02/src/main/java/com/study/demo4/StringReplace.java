package com.study.demo4;

public class StringReplace {
    public static void main(String[] args) {
        String idCardNum = "340103199803170016";
        //数据脱敏
        // 1.hutool工具包数据脱敏工具类
        // 2.正则表达式实现
        String maskIdCardNum = idCardNum.replaceFirst("(\\d{6})\\d{8}([\\dXx]{4})","$1********$2");//$1=340104  $2=001X
        System.out.println(maskIdCardNum);

        String phoneNum = "17352959317";
        String maskPhoneNum = phoneNum.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
        System.out.println(maskPhoneNum);
    }
}
