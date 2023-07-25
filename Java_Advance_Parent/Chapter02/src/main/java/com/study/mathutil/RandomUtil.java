package com.study.mathutil;

import java.util.Random;

public class RandomUtil {
    public static void main(String[] args) {

        Random r1 = new Random(1000);
        Random r2 = new Random(1000);
        int r1num = r1.nextInt((30 - 10) + 1) + 10;//返回下一个伪随机数，整型的
        int r2num = r2.nextInt((30 - 10) + 1) + 10;

        System.out.println("r1num = " + r1num);
        System.out.println("r2num = " + r2num);
    }
    /**
     * 返回一个介于最小值和最大值之间的伪随机数。min和max之间的差值最多小于<code>Integer。MAX_VALUE - 1 ></code>。
     *
     * @param min 最小值
     * @param max 最大值
     * @return 最小和最大值之间的整数，包括最大值。
     * @see java.util.Random#nextInt(int)
     */

    public static int randInt(int min, int max) {
        Random rand = new Random();
        // nextInt通常不包含顶部值，因此加上1使其包含
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
