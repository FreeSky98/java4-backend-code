package org.homework;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeopleTest {
    public static <T> List<T> fillProps(Class<T> clazz, List<Map<String, Object>> dataMap) throws IllegalAccessException, InstantiationException {
        List<T> result = new ArrayList<>();

        for (Map<String, Object> map : dataMap) {
            T obj = clazz.newInstance(); // 创建对象实例

            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                Field field;
                try {
                    field = clazz.getDeclaredField(fieldName); // 获取属性对象
                    field.setAccessible(true); // 设置访问权限，允许对私有属性进行赋值
                    field.set(obj, fieldValue); // 动态赋值给属性
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
            result.add(obj);
        }
        return result;
    }

    public static void main (String[] args) {
        // 定义Class对象和Map数据
        Class<People> clazz = People.class;
        List<Map<String, Object>> dataMap = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "王配全");
        map1.put("age", 25);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "黄赵");
        map2.put("age", 24);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("name", "张锦哲");
        map3.put("age", 19);
        dataMap.add(map1);
        dataMap.add(map2);
        dataMap.add(map3);

        try {
            // 使用fillProps方法进行动态赋值
            List<People> peopleList = fillProps(clazz, dataMap);

            // 输出结果进行验证
            for (People people : peopleList) {
                System.out.println(people);
            }
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}

class People {
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public People() {
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
        return "People{" +
                "姓名='" + name + '\'' +
                ", 年龄=" + age +
                '}';
    }
}
