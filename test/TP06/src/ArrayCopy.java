import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] args) {
        //1数组拷贝
        /*int[] original = {1,2,3,4,5};
        int[] target = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            target[i] = original[i];
        }
        for (int item : target) {
            System.out.println(item);
        }*/

        // 2.数组复制（拷贝）
        int[] oldArr = {1,2,3,4,5};
        /* 将 oldArr数组首地址赋值给newArr,换句话说oldArr和newArr两个整型数组对象变量指向
        同一块内存空间,旧地址的数值变化，新数值也跟着变
         */
       /* int[] newArr = oldArr;
        newArr[0] = 2;
        newArr[1] = 4;
        newArr[2] = 8;
        newArr[3] = 10;
        newArr[4] = 12;
        for (int item : oldArr) {
            System.out.println(item);
        }*/
        //数组的合并
        int[] arr1 = {2,4,6,8,10};
        int[] arr2 = {1,3,5,7,9};
        int[] arr3 = new int[arr1.length+ arr2.length];
        System.arraycopy(arr1,0,arr3,0,arr1.length);
        System.arraycopy(arr2,0,arr3,arr1.length,arr2.length);
        System.out.println("arr3 = " + Arrays.toString(arr3));
    }
}
