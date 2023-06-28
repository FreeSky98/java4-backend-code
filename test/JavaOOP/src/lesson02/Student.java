package lesson02;

import java.util.Scanner;

public class Student {
    private String name;
    private int age;
    private char sex;

    public Student(String name, int age, char sex) {
        setName(name);
        setAge(age);
        setSex(sex);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 1 && age <= 100) {
            this.age = age;
        }
        else {
            System.err.println("年龄必须介于1~100岁之间,默认值为18岁");
            this.age = 18;
        }
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        if (sex == '男' || sex == '女') {
            this.sex = sex;
        }
        else {
            System.err.println("性别只能是男或者女,默认值为男");
            this.sex = '男';
        }
    }

    public void study() {
        System.out.println("好好学习中");
    }
    public void sleep() {
        System.out.println("好好睡觉中");
    }
    public void talk() {
        System.out.println("好好讨论中");
    }
}

class StudentTest {
    public static void main(String[] args) {
        Student student = new Student("李三光",18,'男');
        Scanner input = new Scanner(System.in);

        System.out.println("请输入姓名：");
        String name = input.next();
        student.setName(name);

        System.out.println("请输入年龄：");
        int age = input.nextInt();
        student.setAge(age);

        System.out.println("请输入性别：");
        char sex = input.next().charAt(0);
        student.setSex(sex);

        System.out.println("student.getName() = " + student.getName());
        System.out.println("student.getAge() = " + student.getAge());
        System.out.println("student.getSex() = " + student.getSex());
        student.sleep();
        student.study();
        student.talk();
    }
}