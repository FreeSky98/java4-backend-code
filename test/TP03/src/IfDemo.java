import java.util.Scanner;

public class IfDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入4位数年份： ");
        int year = input.nextInt();
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        if (isLeapYear) {
            System.out.println(year + "是闰年！");
        }
        System.out.println("感谢您使用本程序！");
    }
}
