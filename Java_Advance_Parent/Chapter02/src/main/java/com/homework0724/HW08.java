package com.homework0724;

public class HW08 {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");

        // 使用 == 进行比较
        System.out.println("使用 == 进行比较:");
        System.out.println("str1 == str2: " + (str1 == str2)); // true，引用相同
        System.out.println("str1 == str3: " + (str1 == str3)); // false，引用不同

        // 使用 equals() 进行比较
        System.out.println("使用 equals() 进行比较:");
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // true，内容相等
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true，内容相等
    }
}