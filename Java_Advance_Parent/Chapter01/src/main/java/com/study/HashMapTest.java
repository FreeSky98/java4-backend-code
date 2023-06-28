package com.study;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer,String> integerStringHashMap = new HashMap<>();
        integerStringHashMap.put(0,null);
        integerStringHashMap.put(1,"James");
        integerStringHashMap.put(2,"Kate");
        integerStringHashMap.put(3,"Tom");
        integerStringHashMap.put(4,"Marry");
        integerStringHashMap.put(5,"Ben");
        integerStringHashMap.put(6,"Taylor");

/*遍历方式（5种）*/
//1.循环遍历
//        Set<Integer> keys = integerStringHashMap.keySet();
//        for (Integer key : keys) {
//            String value = integerStringHashMap.get(key);
//            System.out.println("键" + key + ">>值" + value + ">>key hashCode::" + Objects.hashCode(key));
//        }

//2.使用 For-each 循环遍历 HashMap
//        Set<Map.Entry<Integer,String>> entries = integerStringHashMap.entrySet();
//        for (Map.Entry<Integer, String> entry : entries) {
//            System.out.println(entry.getKey() + ">>" + entry.getValue());
//        }

//3.使用Lambda 表达式遍历HashMap
//        integerStringHashMap.forEach((key,value) -> {
//                    System.out.println(key + ">>" + value);
//        });

//4.Map.Entry<Integer, String>表示一个Key-Value对对象 使用Iterator 遍历HashMap EntrySet
//        Iterator<Map.Entry<Integer,String>> it = integerStringHashMap.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry<Integer, String> next =  it.next();
//            System.out.println(next.getKey() + ">>" +next.getValue());
//        }

//5. 使用 Stream API 遍历 HashMap
//        integerStringHashMap.entrySet().stream().forEach(entry->{
//            System.out.println(entry.getKey() + ">>" + entry.getValue());
//        });
    }
}
