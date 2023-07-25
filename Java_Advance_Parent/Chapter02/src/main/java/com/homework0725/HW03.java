package com.homework0725;

import java.util.Random;

public class HW03 {
    public static String getCaptcha(int length) {
        String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder captcha = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            captcha.append(characters.charAt(index));
        }

        return captcha.toString();
    }
    public static void main(String[] args) {
        System.out.println("长度为15位的随机字符串："+getCaptcha(15));
    }
}
