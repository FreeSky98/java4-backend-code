package com.study.practise;

import java.util.Scanner;

public enum PhasesEnum {
    L1,L2,L3;
    public void study(PhasesEnum L) {
        switch (L) {
            case L1 -> System.out.println("大数据开发工程师");
            case L2 -> System.out.println("大数据挖掘工程师");
            case L3 -> System.out.println("大数据架构师");
            default -> System.out.println("输入错误！");
        }
    }

    public static class Test {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("请输入学习目标：");
            String str = input.next();
            valueOf(str).study(valueOf(str));
        }
    }
}
