package com.homework0725;

import java.util.*;

public class HW01 {
    public static String getCaptcha(int capLength) {
        List<Character> charList = new ArrayList<>();
        for (char i = 48; i <= 57; i++) {
            charList.add(i);
        }
        for (char i = 97; i <= 122; i++) {
            charList.add(i);
        }
        for (char i = 65; i <= 90; i++) {
            charList.add(i);
        }
        Random rand = new Random();
        int randomIndex;
        String codeStr = "";
        for (int i = 0; i < capLength; i++) {
            //每循环一次，重新获取新的下标
            randomIndex = rand.nextInt(charList.size());//每次获取集合的下标 数字
            Character ch = charList.get(randomIndex);//每次通过下标获取元素
            codeStr += Character.toString(ch);//将字符拼接成字符串
        }
        return codeStr;
    }
    public static boolean isLogin(String username,String password) {
        return Objects.equals(username, "admin")
                && Objects.equals(password, "password");
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎使用佺系统===================");
        System.out.print("请输入用户名：");
        String inputUsername = input.next();
        System.out.print("请输入密码：");
        String inputPassword = input.next();

        String captcha = getCaptcha(4);
        System.out.println("验证码："+captcha);
        System.out.print("请输入验证码(不区分大小写)：");
        String inputCaptcha = input.next();

        if (isLogin(inputUsername,inputPassword) && inputCaptcha.equalsIgnoreCase(captcha)) {
            System.out.println("验证通过，请使用本系统");
        } else {
            System.err.println("验证未通过，拒绝使用");
        }
    }
}
