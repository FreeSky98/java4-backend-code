import java.util.Random;

public class Practise02 {
    public static void main(String[] args) {
        int[] nums = new int[10];//声明并分配了长度为10的int型数组空间
        Random random = new Random();//导入随机数的类
        // 产生指定范围随机数 random.nextInt(最大值-最小值+1)+最小值
        for (int i = 0; i < nums.length; i++) {
            int randomNumber = random.nextInt(100) + 1; //1~100的随机数
            nums[i] = randomNumber;
        }
        for (int num:nums
             ) {
            System.out.println("num = " + num);
        }
        int max,min,second;
        max = min = nums[0];
        second = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                second = max;
                max = num;
            } else if (max > second && num > second) {
                second = num;
            }
            if (num < min) {
                min = num;
            }
        }
        System.out.println("最大值为："+max+"最小值为："+min+"第二大的值为："+second);
    }
}
