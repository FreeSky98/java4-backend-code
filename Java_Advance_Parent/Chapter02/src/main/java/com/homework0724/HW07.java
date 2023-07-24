package com.homework0724;

import java.util.Scanner;

public class HW07 {
    public static void main(String[] args) {
        String username = "TOM";
        String password = "1234567";

        Scanner input = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String inputUsername = input.next();
        System.out.print("请输入密码：");
        String inputPassword = input.next();
        if (username.equals(inputUsername) && password.equals(inputPassword)) {
            System.out.println("登录成功！");
        } else {
            System.err.println("用户名或密码不匹配，登录失败！");
        }
    }
}
