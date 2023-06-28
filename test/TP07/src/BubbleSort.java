import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] arr) { //arr形式参数
        for (int i = 0; i < arr.length; i++) { //外层循环排序次数
            for (int j = 0; j < arr.length - 1 - i; j++) { //内层循环下标减去次数
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }// inner for
        }// outer for
    }

    public static void main(String[] args) {
        int[] myList = {16,25,9,90,23};
        System.out.println("排序前:"+ Arrays.toString(myList));
        sort(myList);//myList实际参数
        System.out.println("排序后(升序):"+ Arrays.toString(myList));
    }
}
