package com.study.demo1;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        s1.sex = GenderEnum.MALE;//给属性赋值
        s2.sex = GenderEnum.FEMALE;
        System.out.println(s1.sex);
        System.out.println(s2.sex);
    }
}
