package lesson04.demo;

import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        Student stu1 = new Student("张三",18,1000);
        Student stu2 = new Student("张三",18,1000);
        if (Objects.equals(stu1,stu2)) {
            System.out.println("两个对象变量指向同一块内存空间");
        } else {
            System.out.println("两个对象变量的内存空间不相同");
        }
        System.out.println("第一个学生对象："+stu1);
        System.out.println("第二个学生对象："+stu2);
    }
}
