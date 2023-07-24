package com.study.practise;

public class Peach {
    public static void main(String[] args) {
        System.out.println(f(1));
    }

    public static int f(int n) {
        if (n == 10) {
            return 1;
        } else {
            return (f(n+1)*2) + 2;
        }
    }
//    public static int f(int n) {
//        if (n == 1) {
//            return 1;
//        } else {
//            return f(n-1) * n;
//        }
//    }//1~10阶乘
}
