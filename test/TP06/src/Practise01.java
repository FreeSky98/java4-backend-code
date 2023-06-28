import java.util.Scanner;

public class Practise01 {
    public static void main(String[] args) {
        /*
        有一个数列：8,4,2,1,23,344,12
        1.增强for循环输出数列的值
        2.求数列中所有数值的和
        3.查找某个数的位置（下标）
        4.在数列中查找最大值、最小值
        5.猜数游戏：从键盘中任意输入一个数据，判断数列中是否包含此数
         */
        // 声明、配内存和赋值
        int[] nums = {8,4,2,1,23,344,12};
        System.out.println("1.增强for循环打印数组每个元素如下：");
        for (int num: nums) {
            System.out.println(num);
        }
        System.out.println("2.求数组中各元素的和：");
        int sum = 0; //累加和
        for (int num : nums) {
            sum += num;
        }
        System.out.println("求数组中各元素的和 sum = " + sum);
        System.out.println("3/5.查找某个数在数组中的位置<下标>");
        int index = -1; // 表示指定个数不存在数组中
        Scanner input = new Scanner(System.in);
        System.out.println("请任意输入一个整数:");
        int number = input.nextInt();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == number) {
                index = i;
                break;
            }
        }
        if(index == -1) {
            System.out.println("在数组中没有要找到的目标数据 index = " + index);
        }
        else {
            System.out.println("在数组中找到了目标数据，位置是: index = " + index);
        }

        System.out.println("4.求数组中最大的元素和最小的元素：");
        int max,min;
        max = min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }

            if(nums[i] < min) {
                min = nums[i];
            }
        }
        System.out.println("数组中最大元素max = " + max + ",最小元素min = " + min);
    }
}