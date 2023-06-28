import java.util.Arrays;
import java.util.Scanner;

public class Homework02 {

    public static void main(String[] args) {
        System.out.print("请输入您购买的彩票数量：");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.println("您一共购买了" + num + "张彩票");

        int[] redNums = new int[6];//设置红球数组为6
        int blueNum = 0;
        for (int i = 1; i <= num; i++) { //彩票数量循环
            for (int j = 0; j < redNums.length; j++) { //红球内数字数据
                boolean flag = true;
                int redNum = (int) (Math.random()*33 + 1); //产生随机数
                redNums[j] = redNum;//将随机数赋值给红球数字
                for (int k = 0; k < j; k++) { //排除重复
                    if (redNum == redNums[k]) {
                        flag = false;
                        j--;//可以再次赋值
                        break;
                    }
                }
                if (flag) {
                    System.out.print(redNum + " ");//输出红球数组
                }
            }
            blueNum = (int) (Math.random()*16 + 1);//蓝球随机数
            System.out.print("+ "+ blueNum + "\n");//输出蓝色
        }

        int[] buyRedNum = new int[6];//定义新数组：购买的红球数组
        for (int i = 0; i < redNums.length; i++) {
            System.out.println("请输入您购买的第" + (i+1) + "个红球号码：");
            int inputRedNum = input.nextInt();
            buyRedNum[i] = inputRedNum;//输入的号码赋值给新数组
        }
        System.out.println("您购买的红球号码是："+ Arrays.toString(buyRedNum));

        System.out.println("请输入您购买的蓝球号码：");
        int buyBlueNum = input.nextInt();
        int blueHit = 0;
        if (blueNum == buyBlueNum) {
            blueHit = 1;
        }

        int redCount = 0;
        for (int i = 0; i < redNums.length; i++) {
            if (buyRedNum[i] == redNums[i]) {
                redCount++;
            }
        }
        if (blueHit == 1 && redCount == 0 || blueHit == 1 && redCount == 1) {
            System.out.println("六等奖 5元");
        } else if (blueHit == 1 && redCount == 2 || blueHit == 1 && redCount == 3 || blueHit == 0 && redCount == 4) {
            System.out.println("五等奖 10元");
        } else if (blueHit == 1 && redCount == 4 || blueHit == 0 && redCount == 5 ) {
            System.out.println("四等奖 200元");
        } else if (blueHit == 1 && redCount == 5 ) {
            System.out.println("三等奖 3000元");
        } else if (blueHit == 0 && redCount == 6 ) {
            System.out.println("二等奖 500万元");
        } else if (blueHit == 1 && redCount == 6 ) {
            System.out.println("一等奖 1000万元");
        } else {
            System.out.println("您未中奖，感谢您的参与！");
        }
    }
}
