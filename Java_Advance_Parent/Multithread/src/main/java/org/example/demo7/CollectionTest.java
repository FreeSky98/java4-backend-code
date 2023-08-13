package org.example.demo7;

import java.util.*;

public class CollectionTest {
    /**
     * 线程不安全的集合
     */
    private static List<Integer> integerList = new ArrayList<>();
    private static Map<String, Object> stringObjectMap = new HashMap<>();
    private static Set<String> stringSet = new HashSet<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(()-> {
                System.out.println("【"+ Thread.currentThread().getName() + "】正在往集合添加数据");
                for (int j = 0; j < 10000; j++) {

                    integerList.add(new Random().nextInt(100));
                }
            },"线程" + (i+1)).start();
        }
        // numList.forEach(System.out::println);
    }
}
