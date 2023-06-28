import cn.hutool.core.util.ArrayUtil;

import java.util.Arrays;

public class ArrayUtilDemo {
    public static void main(String[] args) {
        //1判断数组是否为空，导入外部包操作
        int[] arr = {};
        int[] arr1 = new int[0];
        int[] arr2 = null;
        System.out.println("arr = " + arr);
        System.out.println("arr1 = " + arr1);
        System.out.println("arr2 = " + arr2);
        boolean isNull = ArrayUtil.isEmpty(arr);
        System.out.println(isNull ? "arr数组为null或长度为0":"arr数组非空");
        //ArrayUtil.resize()调整数组的大小
        Double[] data = {1.0,2.0,3.0,4.0};
        System.out.println(ArrayUtil.toString(data));
        data = ArrayUtil.resize(data,data.length + 1);
        System.out.println(ArrayUtil.toString(data));
        //3.非泛型数组调用第二种重载方法
        int[] a = {1,2,3};
        int[] clone = ArrayUtil.clone(a);
        int[] clone1 = a.clone();
        System.out.println(Arrays.toString(clone));
        System.out.println(Arrays.toString(clone1));
    }
}
