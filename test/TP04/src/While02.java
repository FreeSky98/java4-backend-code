import java.util.Scanner;

public class While02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个整数(0表示结束循环):");
        int n = input.nextInt();
        int max,min;
        max = 0;
        min = n;

        while (n != 0) {
            if (n > max) {
                max = n;
            }
            if (n < min) {
                min = n;
            }
            System.out.println("请输入一个整数(0表示结束循环):");
            n = input.nextInt();
        }
        System.out.println("最大值是:" + max + "\t" + "最小值是:" + min);
        input.close();
    }
}
