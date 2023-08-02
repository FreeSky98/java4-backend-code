package org.example.v5;

import javax.swing.*;
import java.lang.reflect.Constructor;

//测试类
public class AppTest {
    //主方法
    public static void main(String[] args) {
        //1.给定一个类，动态创建该类的实例
        String className = JOptionPane.showInputDialog(
                null,
                "请输入类完全限定名(包名+类名):",
                "org.example.v5.Computer");
        System.out.println("打印：" + className);

        try {
            //获取某个类字节码信息(类的元信息)
            Class<?> clazz = Class.forName(className);
            //new Computer()
            //new Computer("ThinkPad","ThinkBook-16P",10999D);
            // 通过反射获取无参构造器
            //Constructor<?> noArgsConstructor = clazz.getConstructor();
            //<?>表示任何类型
            Constructor<?> constructor = clazz.getConstructor(String.class, String.class, double.class);
            // 创建某个类的实例
            //Computer computer = (Computer)noArgsConstructor.newInstance();
            // Object ... initargs
            Computer computer = (Computer)constructor.newInstance("华为","MateBook",18999);
            System.out.println(computer.showInfo());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}