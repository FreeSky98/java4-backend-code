package com.homework04;

import java.util.ArrayList;

public class ListPrint {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("孙悟空");
        list.add("克林");
        list.add("午饭");
        list.add("比克");
        printArrayList(list);
    }
    public static void printArrayList(ArrayList<String> list) {
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.println(list.get(i) + "}");
            } else {
                System.out.print(list.get(i) + "@");
            }
        }
    }
}
