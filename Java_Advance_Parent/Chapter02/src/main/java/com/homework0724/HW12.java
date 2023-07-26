package com.homework0724;

import java.util.Scanner;

public class HW12 {

    static Scanner input = new Scanner(System.in);

    public static void login() {
        label:do {
            System.out.println("---欢迎进入作业提交系统---");
            System.out.println("请输入Java文件名：");
            String javaFileName = input.next();
            System.out.println("请输入你的邮箱：");
            String email = input.next();
            if (!isPass(javaFileName,email)) {
                System.out.println("作业提交失败！");
            } else {
                System.out.println("作业提交成功！");
                break label;
            }
        } while (true);
    }

    public static boolean isPass(String javaFileName,String email) {
        if (javaFileName.lastIndexOf(".java") == -1) {
            System.out.println("Java文件名后缀有误或非Java文件！");
            return false;
        } else if (email.lastIndexOf("@") == -1 || email.indexOf("@") > email.indexOf(".")) {
            System.out.println("E-mail无效。");
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        login();
    }
}
