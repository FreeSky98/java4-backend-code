import java.util.Arrays;
import java.util.Scanner;

public class IntArrayCRUD {
    static Scanner input = new Scanner(System.in);
    static int[] nums = new int[8];
    public static void insert() {
        System.out.println("请输入插入的新元素：");
        int num = input.nextInt();
        System.out.println("请输入要插入的位置：");
        int pos = input.nextInt();

        if (pos < 0 || pos > 8) {
            System.err.println("数组的位置在范围外");
        }
        else {
            nums = Arrays.copyOf(nums,nums.length + 1);
            System.out.println(Arrays.toString(nums));
        }//扩容操作

        for (int i = nums.length - 1; i > pos; i--) {
            nums[i] = nums[i - 1];
        }//从pos位置之后的所有元素依次往后移动一位

        nums[pos] = num;
        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        nums[0] = 6;
        nums[1] = 12;
        nums[2] = 33;
        nums[3] = 67;
        nums[4] = 83;
        nums[5] = 95;
        nums[6] = 56;
        nums[7] = 90;
        insert();
    }
}
