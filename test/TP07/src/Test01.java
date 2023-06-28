import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入4位数年份：");
        int year = input.nextInt();
        System.out.println("请输入月份：");
        int month = input.nextInt();
        System.out.println("请输入日期：");
        int day = input.nextInt();
        int sumDays = 0;

        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0 ) || year % 400 == 0;
        if (isLeapYear) {
            switch (month) {
                case 1 -> sumDays = day;
                case 2 -> sumDays = 31 + day;
                case 3 -> sumDays = 60 + day;
                case 4 -> sumDays = 91 + day;
                case 5 -> sumDays = 121 + day;
                case 6 -> sumDays = 152 + day;
                case 7 -> sumDays = 182 + day;
                case 8 -> sumDays = 213 + day;
                case 9 -> sumDays = 244 + day;
                case 10 -> sumDays = 274 + day;
                case 11 -> sumDays = 304 + day;
                case 12 -> sumDays = 335 + day;
            }
        } else {
            switch (month) {
                case 1 -> sumDays = day;
                case 2 -> sumDays = 31 + day;
                case 3 -> sumDays = 59 + day;
                case 4 -> sumDays = 90 + day;
                case 5 -> sumDays = 120 + day;
                case 6 -> sumDays = 151 + day;
                case 7 -> sumDays = 181 + day;
                case 8 -> sumDays = 212 + day;
                case 9 -> sumDays = 243 + day;
                case 10 -> sumDays = 273 + day;
                case 11 -> sumDays = 303 + day;
                case 12 -> sumDays = 334 + day;
            }
        }
        System.out.println("您输入的是:"+year+"年"+month+"月"+day+"日");
        System.out.println(year+"年"+month+"月"+day+"日是"+year+"年中第"+sumDays+"天");
    }
}
