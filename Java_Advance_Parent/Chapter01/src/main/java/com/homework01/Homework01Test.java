package com.homework01;

import java.util.ArrayList;

public class Homework01Test {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("张三","12310001"));
        list.add(new Student("李四","12320002",89,93,94));
        list.add(new Teacher("王五","12330003",4000));

        for (Person person : list) {
            System.out.println(person);
        }
    }

    public static class Person {
        private String name;
        private String idNumber;

        public Person(String name, String idNumber) {
            this.name = name;
            this.idNumber = idNumber;
        }

        public Person() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIdNumber() {
            return idNumber;
        }

        public void setIdNumber(String idNumber) {
            this.idNumber = idNumber;
        }

        @Override
        public String toString() {
            return "姓名：" + name + " 身份证号：" + idNumber;
        }
    }

    public static class Student extends Person {
        private int ChineseScore;
        private int MathScore;
        private int EnglishScore;

        public Student(String name, String idNumber, int chineseScore, int mathScore, int englishScore) {
            super(name, idNumber);
            ChineseScore = chineseScore;
            MathScore = mathScore;
            EnglishScore = englishScore;
        }

        public Student(int chineseScore, int mathScore, int englishScore) {
            ChineseScore = chineseScore;
            MathScore = mathScore;
            EnglishScore = englishScore;
        }

        public int getChineseScore() {
            return ChineseScore;
        }

        public void setChineseScore(int chineseScore) {
            ChineseScore = chineseScore;
        }

        public int getMathScore() {
            return MathScore;
        }

        public void setMathScore(int mathScore) {
            MathScore = mathScore;
        }

        public int getEnglishScore() {
            return EnglishScore;
        }

        public void setEnglishScore(int englishScore) {
            EnglishScore = englishScore;
        }

        @Override
        public String toString() {
            return super.toString() +" 语文：" + ChineseScore + " 数学：" + MathScore + " 英文：" + EnglishScore ;
        }
    }

    public static class Teacher extends Person {
        private double salary;//工资

        public Teacher(String name, String idNumber, double salary) {
            super(name, idNumber);
            this.salary = salary;
        }

        public Teacher(double salary) {
            this.salary = salary;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return super.toString() + "工资：" + salary ;
        }
    }
}
