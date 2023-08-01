package org.homework;

import java.lang.reflect.Field;

public class Homework01 {
    public static void main(String[] args) {
        privateTest privateTest = new privateTest();
        System.out.println("改变前的姓名：" + privateTest.getName());
        Class<? extends org.homework.privateTest> aClass = privateTest.getClass();
        Field privateField = null;
        try {
            privateField = aClass.getDeclaredField("name");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        privateField.setAccessible(true);
        // 修改私有字段的值
        try {
            privateField.set(privateTest, "HelloWorld");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        //打印后
        System.out.println("改变后的姓名：" + privateTest.getName());
    }
}

class privateTest {
    private String name = "hellokitty";

    public String getName() {
        return name;
    }

    public privateTest() {
    }

    public privateTest(String name) {
        this.name = name;
    }
}