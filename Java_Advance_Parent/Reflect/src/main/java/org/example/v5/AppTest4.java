package org.example.v5;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AppTest4 {
    public static void main(String[] args) throws Exception {
//        Class.forName("org.example.v5.ArrayTool");
        Class<ArrayTool> clazz = ArrayTool.class;
        Method method = clazz.getDeclaredMethod("reverse", int[].class);

        int[] ints = new int[]{1,2,3,4,32,12};
        method.invoke(null, ints);
        System.out.println(Arrays.toString(ints));
    }
}
