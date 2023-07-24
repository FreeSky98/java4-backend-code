package com.homework03;

import java.util.HashMap;
import java.util.Map;

public class StudentManager {
    public static final Map<String,Student> studentMap = new HashMap<>();

    static {
        Student s1 = new Student("1001","张一",18,"男");
        Student s2 = new Student("1002","张二",17,"男");
        Student s3 = new Student("1003","张三",19,"女");
        Student s4 = new Student("1004","李四",20,"女");
        Student s5 = new Student("1005","王思",18,"男");
        Student s6 = new Student("1006","王五",21,"男");
        Student s7 = new Student("1007","赵六",16,"女");
        Student s8 = new Student("1008","赵启",19,"男");
        Student s9 = new Student("1009","李三",17,"女");
        Student s10 = new Student("10010","田七",20,"男");
        studentMap.put(s1.getId(),s1);
        studentMap.put(s2.getId(),s2);
        studentMap.put(s3.getId(),s3);
        studentMap.put(s4.getId(),s4);
        studentMap.put(s5.getId(),s5);
        studentMap.put(s6.getId(),s6);
        studentMap.put(s7.getId(),s7);
        studentMap.put(s8.getId(),s8);
        studentMap.put(s9.getId(),s9);
        studentMap.put(s10.getId(),s10);
    }
}
