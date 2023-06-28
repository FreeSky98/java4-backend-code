import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ArraysDemo {
    public static void main(String[] args) {
        /*int[] arr1 = {9,8,7};
        int[] arr2 = {9,87};
        boolean isEqual = Arrays.equals(arr1,arr2);
        System.out.println(isEqual?"相等":"不相等");*/
        //比较两个数组是否相等


        /*int[][] array = new int[][]{
                {80,66},
                {70,54,98},
                {77,59}
        };
        for (int i = 0; i < array.length; i++) {
            String str = (i + 1) + "班";
            Arrays.sort(array[i]);
            System.out.println(str + "成绩排序后：");
            for (int j = 0; j < array[i].length; j++) {
                System.out.println(array[i][j]);
            }

            System.out.println(str);
        }*/
        //数组排序


        /*int[] arr = {1,2,3,4};
        arr = Arrays.copyOf(arr,arr.length * 2);
        System.out.println(Arrays.toString(arr));*/
        //将数组复制成一个长度设定的新数组


        /*int[] arr5 = {18,9,11,29,40,18,45,3};
        Arrays.sort(arr5);
        System.out.println("打印已排的数组：" + Arrays.toString(arr5));
        int key = 40;
        int index = Arrays.binarySearch(arr5, 40);
        System.out.println(key+"在数组（按升序排序）的下标(索引)：" + index);*/
        //查询数组中的下标


        /*Arrays.asList(new int[]{1,2,3,4,5,6});
        List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5, 6);
        Object[] arr = myList.toArray();
        System.out.println(Arrays.toString(arr));*/
        //asList(T... a) 将数组转换为ArrayList(动态数组)
        //toArray()   将ArrayList(动态数组)转换为数组
    }
}
