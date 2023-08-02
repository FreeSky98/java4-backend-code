package org.example.v5;

import javax.swing.*;
import java.lang.reflect.Field;

public class AppTest2 {
    public static void main(String[] args) {
        String className = JOptionPane.showInputDialog(
                null,
                "请输入类完全限定名(包名+类名):",
                "org.example.v5.Computer"
        );
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try {
            Class<?> clazz = classLoader.loadClass(className);
            Object object = clazz.getConstructor().newInstance();
            Field[] declaredFields = clazz.getDeclaredFields();//获取某个类的所有属性(任何访问修饰符)
            int length = declaredFields.length;
            System.out.println("length = " + length);
            for (Field field : declaredFields) {
                String fieldName = field.getName();//获取属性名
                field.setAccessible(true);//设定私有的属性允许访问
                switch (fieldName) {
                    case "brand" -> {
                        field.set(object,"HP/惠普");
                        System.out.println(field.get(object));
                    }
                    case "type" -> {
                        field.set(object,"14-eh");
                        System.out.println(field.get(object));
                    }
                    case "price" -> {
                        field.set(object,5799D);
                        System.out.println(field.get(object));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
