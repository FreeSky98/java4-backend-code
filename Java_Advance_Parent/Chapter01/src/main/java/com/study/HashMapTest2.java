package com.study;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest2 {
    public static void main(String[] args) {
        Map<String,String> countryMap = new HashMap<>();

        countryMap.put("CN","中华人民共和国");
        countryMap.put("JP","日本");
        countryMap.put("US","美利坚合众国");
        countryMap.put("RU","俄罗斯联邦");

        String country = countryMap.get("CN");
        System.out.println("CN对应的国家是"+country);

        System.out.println("countryMap中一共有" + countryMap.size() + "组数据");

        boolean containsKey = countryMap.containsKey("FR");
        System.out.println("countryMap中包含FR的key么？" + containsKey);

        countryMap.putIfAbsent("FR","法国");
        boolean containsValue = countryMap.containsValue("法国");
        System.out.println("countryMap中包含FR的key么？" + containsValue);

        boolean isEmpty = countryMap.isEmpty();
        System.out.println("countryMap中是否为空？" + isEmpty);

        System.out.println("输出countryMap中所有的key集：" + countryMap.keySet());

        System.out.println("输出countryMap中所有的Value集：" + countryMap.values());

        System.out.println("输出countryMap中所有的KV集：" + countryMap.entrySet());

        countryMap.clear();
        isEmpty = countryMap.isEmpty();
        System.out.println("countryMap中是否为空？" + isEmpty);
    }
}
