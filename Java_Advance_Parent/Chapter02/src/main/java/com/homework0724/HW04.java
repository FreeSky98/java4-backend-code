package com.homework0724;

import java.util.Scanner;

public class HW04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("我行我素购物管理系统 ->幸运抽奖");
        System.out.print("请输入4位会员号码：");
        String userNum = input.next();
        HW04Random.bingo(userNum);
    }

    public static class HW04Random {
        public static void bingo(String userNum) {
            int userNumToInt = Integer.parseInt(userNum);
            int compareNum = (userNumToInt % 1000) / 100;
            int bingoNum = (int) (Math.random() * 10);
            System.out.println("中奖号码：" + bingoNum);
            System.out.println("客户比对号码：" + compareNum);
            if (compareNum == bingoNum) {
                System.out.println(userNum + "是幸运客户，获得精美MP3一个。");
            } else {
                System.out.println(userNum + "的客户，很遗憾您未中奖。");
            }
        }
    }
}


