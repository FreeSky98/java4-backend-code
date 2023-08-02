package org.example.v5;

public class ArrayTool {

    /**数组的遍历
     @param arr 要遍历的数组
     */
    public static void printArr(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    /**
     数组获取最大值
     @param arr 要获取最大值的数组
     @return 获取到的最大值
     */
    public static int getMax(int[] arr) {
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    /**
     获取数组最小值
     @param arr 要获取最小值的数组
     @return 获取到的最小值
     */
    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < min) {
                min  = arr[i];
            }
        }
        return min;
    }
    /**
     交换数组中的两个元素
     @param arr 要交换元素的数组
     @param a 要交换的第一个元素的索引
     @param b 要交换的第二个元素的索引
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    /**
     数组反转
     @param arr 要反转的数组
     */
    public static void reverse(int[] arr) {
        for(int i = 0, j = arr.length - 1; i < j; i++, j--) {
            swap(arr, i, j);
        }
    }
    /**
     冒泡排序
     * @param arr 要排序的数组
     */
    public static void paiXu(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr.length-1-i;j++) {
                if(arr[i]<arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }
}
