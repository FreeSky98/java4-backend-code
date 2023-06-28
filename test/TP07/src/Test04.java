import java.util.Arrays;
import java.util.Scanner;

public class Test04 {
    static Scanner input = new Scanner(System.in);
    static int[] nums = new int[6];
    public static void insert() {
        System.out.println("请输入插入的新元素：");
        int num = input.nextInt();
        System.out.println("请输入要插入的位置：");
        int pos = input.nextInt();

        if (pos < 0 || pos > 6) {
            System.err.println("数组的位置在范围外");
        }
        else {
            nums = Arrays.copyOf(nums,nums.length + 1);
            System.out.println(Arrays.toString(nums));
        }

        for (int i = nums.length - 1; i > pos; i--) {
            nums[i] = nums[i - 1];
        }

        nums[pos] = num;
        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        nums[0] = 100;
        nums[1] = 99;
        nums[2] = 85;
        nums[3] = 82;
        nums[4] = 63;
        nums[5] = 60;
        insert();
    }
}
