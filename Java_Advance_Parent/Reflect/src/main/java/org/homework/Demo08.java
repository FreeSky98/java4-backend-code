package org.homework;

import java.lang.reflect.Field;

public class Demo08 {
    public static void main(String[] args) throws Exception{
        Person p = new Person("zhangsan", 23);//在main方法中，创建了一个Person对象p，属性name设置为"zhangsan"，属性age设置为23。
        set(p, "age", 24);//调用set方法修改p对象的age属性为24
        System.out.println(p);//最后打印p对象。
    }

    public static void set(Object obj, String propertyName, Object value) throws Exception {
        //定义了一个名为set的静态方法，接受三个参数：
        // Object类型的obj表示要修改的对象，String类型的propertyName表示要修改的属性名，Object类型的value表示要修改的属性值。
        Class<?> c = obj.getClass();//通过getClass方法获取obj对象的Class对象，以便后续进行反射操作。

        Field field = c.getDeclaredField(propertyName);//使用getDeclaredField方法访问私有属性，从Class对象中获取指定名称的属性Field对象。
        field.setAccessible(true);//接着调用setAccessible(true)方法设置Field对象可访问，因为私有属性默认是不可访问的。
        field.set(obj, value);//使用set方法将指定对象obj的指定属性的值修改为value。
        //这样就完成了通过方法反射的方式来修改指定对象的指定属性值。
    }
}

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}