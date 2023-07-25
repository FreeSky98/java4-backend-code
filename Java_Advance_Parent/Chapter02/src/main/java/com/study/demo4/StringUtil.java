package com.study.demo4;

import java.util.Objects;

public class StringUtil {
    public static void main(String[] args) {
        String str1 = "你好";//字符串字面量
        String str2 = new String("你好");//字符串对象
        System.out.println("str1引用地址值 = " + System.identityHashCode(str1));
        System.out.println("str2引用地址值 = " + System.identityHashCode(str2));
        if (str1 == str2) {
            System.out.println("两个对象地址值相等");
        } else {
            System.out.println("两个对象地址值不相等");
        }

        if (str1.equals(str2)) {
            System.out.println("两个对象内容相等");
        } else {
            System.out.println("两个对象内容不相等");
        }

        if (str1.contentEquals(str2)) {
            System.out.println("两个对象内容相等");
        } else {
            System.out.println("两个对象内容不相等");
        }

        if (Objects.equals(str1,str2)) {
            System.out.println("两个对象内容相等");
        } else {
            System.out.println("两个对象内容不相等");
        }
    }
}
