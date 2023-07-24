package com.homework0724;

import java.util.Scanner;

public class HW06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String username = input.next();
        System.out.print("请输入密码：");
        String password = input.next();
        if (password.length() < 6) {
            System.err.println("密码长度不能小于6位！");
        } else {
            System.out.println("注册成功！");
        }
    }
}
