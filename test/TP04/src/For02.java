import java.util.Scanner;

public class For02 {
    public static void main(String[] args) {
        System.out.print("整数（ゼロ以上）を入力してください：");
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();
        System.out.println("プラス表：");

        for (int i = 0, j = num; i <= num && j >= 0; i++, j--) {
            System.out.printf("%d + %d = %d %n", i, j, (i + j));
        }
    }
}
