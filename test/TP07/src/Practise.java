import java.util.Scanner;

public class Practise {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int classNum = 3;
        int studentNum = 5;
        int[][] scores = new int[classNum][studentNum];
        int[] totals = new int[scores.length];
        for (int i = 0; i < scores.length; i++) { //班级数量遍历
            System.out.println("*************第"+(i+1)+"个班"+"*************");
            totals[i] = 0;//重置 分别存储每个班的总成绩
            for (int j = 0; j < scores[i].length; j++) { //控制每个班级学生数量
                System.out.println("请输入第"+(j+1)+"个学生的成绩:");
                scores[i][j] = input.nextInt();
                totals[i] += scores[i][j];
            }// end for
        }// end for
        System.out.println("**********************成绩汇总************************");
        for (int i = 1; i <= totals.length; i++) {
            System.out.println(i + "班总成绩：" + totals[i - 1]);
        }
    }
}
