package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestReflect {

    public static void main(String[] args) throws Exception{
        Class clazz = PatientP0.class;
        Object obj = clazz.getConstructor().newInstance();
/*        Field field = clazz.getDeclaredField("列名");
        field.setAccessible(true);
        String value = rs.getString("patientName");
        field.set(obj, value);*/
        //Field[] fields = clazz.getDeclaredFields();
        //for (Field field : fields) {
        //System.out.println(field.getName());
        //System.out.println(field.getType());
        //System.out.println(Modifier.toString(field.getModifiers()));
        //if("patientName".equals(field.getName())) {
        //field.setAccessible(true);
        //field.set(obj, "欧阳增强");
        //System.out.println("病人姓名：" + field.get(obj));
        //}
        //}

    }
}
