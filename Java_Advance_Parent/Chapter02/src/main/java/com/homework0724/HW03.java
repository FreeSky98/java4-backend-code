package com.homework0724;

public class HW03 {
    public static void main(String[] args) {
        int res1 = Integer.valueOf(21);
        System.out.println(res1);

        String str = "21";
        int res2 = Integer.valueOf(str);
        System.out.println(res2);

        int a = 21;
        Integer b = a;

        Integer c = 21;
        int d = c;

        String str1 = "false";
        boolean res3 = Boolean.valueOf(str1);
        System.out.println(res3);

        char sex = '男';
        String res4 = Character.toString(sex);
        System.out.println(res4);
    }
}
