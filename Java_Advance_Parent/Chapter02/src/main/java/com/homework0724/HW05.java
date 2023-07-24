package com.homework0724;

import java.util.Random;

public class HW05 {
    public static void main(String[] args) {
        Random random1 = new Random(123);
        Random random2 = new Random(123); // 使用相同的种子值123初始化另一个Random对象

        for (int i = 0; i < 20; i++) {
            int randomNumber = random1.nextInt(10); // 生成随机整数
            System.out.println("第"+(i+1)+"个随机数是："+randomNumber); // 显示随机整数
            random1.nextInt(); // 前进到下一个整型的伪随机数
            random2.nextInt();
        }
    }
}
