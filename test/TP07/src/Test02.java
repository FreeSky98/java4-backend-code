import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int up = 0;
        int down = 0;
        int number = 0;
        int other = 0;

        System.out.print("请输入一个字符串：");
        String str = input.nextLine();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                down++;
            }
            else if (ch >= 'A' && ch <= 'Z') {
                up++;
            }
            else if (ch >= '0' && ch <= '9') {
                number++;
            }
            else {
                other++;
            }
        }
        System.out.println("输出的"+str+"中大写字母有:"+up+"个,小写字母有:"+down+"个,数字字符有:"+ number+"个,其他字符有:"+other+"个");
    }
}
