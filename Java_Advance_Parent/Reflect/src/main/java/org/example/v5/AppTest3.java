package org.example.v5;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class AppTest3 {
    /**
     *
     * @param obj 反射出未知类的对象
     * @param fieldName 属性名称
     */
    public static void set(Object obj,String fieldName,Object ... args) throws Exception {
        // 1.通过对象名.getClass()获取未知类字节码信息
        Class<?> aClass = obj.getClass();
        // 2.组装setXxx方法名   前缀: set     后缀：name  =  Name   set+Name
        final String PREFIX = "set";
        String methodName = PREFIX + lowerLetterFirst(fieldName);
        Field field = aClass.getDeclaredField(fieldName);
        //Method methods1 = aClass.getMethod(); //所有公共方法，包括继承来的方法
        //Method  methods2 = aClass.getDeclaredMethod(); //所有公共、私有、默认、包级方法，不包括继承来的方法
        Method method = aClass.getMethod(methodName, field.getType());
        method.invoke(obj, args);
    }

    /**
     * 将属性名的首字母改为大写
     * @param fieldName 传入的属性名
     * @return 大写后的属性名
     */
    public static String lowerLetterFirst(String fieldName) {
        char[] chars = fieldName.toCharArray();//char[]
        //A：65    a：97    97-65=32
        chars[0] -= 32;
        return String.valueOf(chars);
    }
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入类完全限定名(包名+类名):");
        String className = input.next();

        Class<?> clazz = Class.forName(className);
        Object object = clazz.getConstructor().newInstance();//动态创建某个类的实例对象
        set(object,"brand","Lenovo/联想");
        set(object,"type","小新 pro14");
        set(object,"price",7879.0);

        Method showInfoMethod = clazz.getMethod("showInfo", null);
        Object result = showInfoMethod.invoke(object, null);//invoke动态调用
        System.out.println("result = " + result);
    }
}
