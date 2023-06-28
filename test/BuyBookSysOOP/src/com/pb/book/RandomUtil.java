package com.pb.book;

/**
 * 随机工具类
 * @author lds
 */
public class RandomUtil {
    /**
     * 随机生指定范围的长整型
     * @param min 最小值
     * @param max 最大值
     * @return 返回指定范围的长整型
     */
    public static long randomLong(int min,int max) {
       long num =  (long)(Math.random() * (max - min + 1)) + min;
       return num;
    }
}
