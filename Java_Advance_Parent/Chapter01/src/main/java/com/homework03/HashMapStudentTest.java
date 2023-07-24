package com.homework03;

import java.util.Scanner;

public class HashMapStudentTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入学生的学号：");
        String inputId = input.next();
        if (StudentManager.studentMap.containsKey(inputId)) {
            System.out.println(StudentManager.studentMap.get(inputId).toString());
        } else {
            System.err.println("未找到该学生！");
        }
    }
}
