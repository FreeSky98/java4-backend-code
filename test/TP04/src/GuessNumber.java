import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        int randomNum = (int) (Math.random() * 100 ) + 1;
        System.out.println("作弊数字：" + randomNum);
        Scanner input = new Scanner(System.in);
        System.out.print("请输入猜测的数字(1~100)：");
        int guessNum = input.nextInt();
        int numberOfGuesses = 0;

        while (true) {
            numberOfGuesses++;
            if (guessNum > randomNum) {
                System.out.println("偏大，再想想~");
                guessNum = input.nextInt();
            }
            else if (guessNum < randomNum) {
                System.out.println("偏小，再想想~");
                guessNum = input.nextInt();
            }
            else {
                System.out.println("恭喜你猜对了!你一共猜测了" + numberOfGuesses + "次");
                break;
            }
        }
        input.close();
    }
}
