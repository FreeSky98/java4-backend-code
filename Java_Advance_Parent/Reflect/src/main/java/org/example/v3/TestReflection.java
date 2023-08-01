package org.example.v3;

import java.lang.reflect.Modifier;

/**
 * 使用反射获取任意类的信息（属性、方法（实例、静态）、构造方法）
 */
public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.Class.forName(完整类名)
        Class clazz1 = Class.forName("org.example.v3.Teacher");
        //2.任意对象名.getClass()
        Teacher zhang = new Teacher();
        Class clazz2 = zhang.getClass();
        //3.任意类型.class
        Class clazz3 = Teacher.class;

        String name = clazz1.getName();
        System.out.println("完整路径："+name);
        String simpleName = clazz1.getSimpleName();
        System.out.println("简称："+simpleName);

        Package pkg = clazz1.getPackage();
        System.out.println(simpleName+"类定义在"+pkg.getName()+"包中");
        Class superClass = clazz1.getSuperclass();
        System.out.println(simpleName+"类的父类是："+superClass.getName());

        Class[] interfaces = clazz1.getInterfaces();
        System.out.println(simpleName + "类所实现的接口如下：");
        for (Class anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }

        int mod = clazz1.getModifiers();
        String modStr = Modifier.toString(mod);
        System.out.println(simpleName+"类的访问修饰符是："+modStr);

    }
}
