package com.homework0724;

import java.util.Scanner;

public enum HW01Enum {
    MON,TUE,WED,THU,FRI,SAT,SUN;

    public void study(HW01Enum week) {
        switch (week) {
            case MON,TUE,WED,THU,FRI -> System.out.println("工作日，努力写代码！");
            case SAT,SUN -> System.out.println("休息日，好好去放松！");
            default -> System.out.println("不是有效的星期！");
        }
    }

    public static class HW01Test {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.print("请输入今天是星期几(MON,TUE,WED,THU,FRI,SAT,SUN)：");
            HW01Enum week = valueOf(input.next());
            week.study(week);
        }
    }
}
