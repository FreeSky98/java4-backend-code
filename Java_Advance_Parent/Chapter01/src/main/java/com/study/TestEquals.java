package com.study;

import java.util.ArrayList;

public class TestEquals {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student zhang1 = new Student(1, "张三");
        list.add(zhang1);
        Student zhang2 = new Student(1,"张三");
        // 当两个不同的学生对象变量属性值完全相等，我们视为同一个学生对象（指向同一块内存单元）
        //if(list.contains(zhang2)) {
        //if(list.indexOf(zhang2) != -1) {
        if(list.contains(zhang2)) {
            System.out.println("两个学生对象相等!");
        }
        else {
            System.out.println("两个学生对象不相等!");
        }
    }
}
