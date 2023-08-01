package org.example.v3;

public class People {
    /**
     人类：父类
     */
    private String name;
    private int age;

    public People() {
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     查看课表
     */
    public void queryCourse(){
        System.out.println(name + "正在查看课表~");
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
        this.age = age;
    }
}
//子类代码有两个，学生类和老师类


