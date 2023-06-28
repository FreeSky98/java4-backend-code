import java.util.Scanner;

public class For01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("受験生の名前を入力してください：");
        String name = input.next();
        int sum = 0;
        final int N = 5;

        for (int i = 1; i <= 5; i++) {
            System.out.println("受験生"+name+"の第"+i+"科目の成績：");
            int score = input.nextInt();
            if (score < 0 || score > 100){
                System.out.println("入力した成績が不合理である。成績は[0~100]以内にお願いします。");
                i--;
                continue;//跳过本次循环进入下一个循环    break;是终止整个循环
            }
            sum += score;
        }
        double avg = (double) sum / N;
        System.out.println(name + "のテストの平均値は:" + avg);
    }
}
