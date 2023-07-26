package com.homework0724;

import java.util.Scanner;

public class HW10 {

    static Scanner input = new Scanner(System.in);

    public static boolean isLegalLength(String usernameReg,String passwordReg) {
        if (usernameReg.length() < 3 || passwordReg.length() < 6) {
            System.out.println("用户名长度不能小于3，密码长度不能小于6！");
            return false;
        }
        return true;
    }


    public static boolean isSamePassword(String passwordReg,String passwordRegAgain) {
        if (!passwordReg.equals(passwordRegAgain)) {
            System.out.println("两次输入的密码不相同！");
            return false;
        }
        return true;
    }

    public static void login() {
        label:do {
            System.out.println("***欢迎进入注册系统***");
            System.out.println();
            System.out.println("请输入用户名：");
            String usernameReg = input.next();
            System.out.println("请输入密码：");
            String passwordReg = input.next();
            System.out.println("请再次输入密码：");
            String passwordRegAgain = input.next();
            if (isLegalLength(usernameReg,passwordReg) && isSamePassword(passwordReg,passwordRegAgain)) {
                System.out.println("注册成功！请牢记用户名和密码。");
                break label;
            }
        } while (true);
    }
    public static void main(String[] args) {
        login();
    }
}
