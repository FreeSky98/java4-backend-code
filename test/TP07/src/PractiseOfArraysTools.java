import java.util.Arrays;

public class PractiseOfArraysTools {
    public static void main(String[] args) {
        char[] chars = {'p','z','x','a','t','b','e'};
        Arrays.sort(chars);
        System.out.println("排序后：" + Arrays.toString(chars));
        int index = Arrays.binarySearch(chars,'e');
        System.out.println("e的下标是：" + index);
    }
}
