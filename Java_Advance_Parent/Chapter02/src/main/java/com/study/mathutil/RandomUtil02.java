package com.study.mathutil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtil02 {
    public static void main(String[] args) {
//        String captcha = generateCaptcha(6);
//        System.out.println("Generated Captcha: " + captcha);
//    }

        //随机生成图形验证码 包含【0-9】和字母【a-zA-Z】
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
        charList.forEach(System.out::println);

        Random rand = new Random();
        int randomIndex;
        int length = 4;
        String codeStr = "";
        for (int i = 0; i < length; i++) {
            //每循环一次，重新获取新的下标
            randomIndex = rand.nextInt(charList.size());//每次获取集合的下标 数字
            Character ch = charList.get(randomIndex);//每次通过下标获取元素
            codeStr += Character.toString(ch);//将字符拼接成字符串
        }
        System.out.println("\n\n产生随机验证码 codeStr = " + codeStr);
    }
}
//    public static String generateCaptcha(int length) {
//        String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        StringBuilder captcha = new StringBuilder();
//        Random random = new Random();
//
//        for (int i = 0; i < length; i++) {
//            int index = random.nextInt(characters.length());
//            captcha.append(characters.charAt(index));
//        }
//
//        return captcha.toString();
//    }
//}
