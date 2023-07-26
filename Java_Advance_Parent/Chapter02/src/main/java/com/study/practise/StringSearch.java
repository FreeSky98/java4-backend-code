package com.study.practise;

import java.util.Scanner;

public class StringSearch {

    public static int strTimes(String inputStr, String findStr) {
        int count = 0;//计数器
        int index = 0;//查找下标
        while ((index = inputStr.indexOf(findStr, index)) != -1) {
            count++;
            index += findStr.length(); //下标累加（需要查找的字符串）长度
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入字符串：");
        String inputStr = input.nextLine();//输入的字符串
        System.out.print("请输入要查找的字符串：");
        String findStr = input.nextLine();//需要查找的字符串
        System.out.println("一共出现了：" + strTimes(inputStr, findStr) + "次");
    }
}