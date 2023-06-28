import java.util.Scanner;

public class Practise04 {
    public static void main(String[] args) {
        System.out.println("简易计算器");
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一个整数：");
        int n1 = input.nextInt();
        System.out.println("请输入运算符(+、-、*、/、%):");
        char op =input.next().charAt(0);
        System.out.println("请输入第二个整数：");
        int n2 = input.nextInt();
        int result = 0;
        switch (op) {
            case '+' -> result = n1 + n2;
            case '-' -> result = n1 - n2;
            case '*' -> result = n1 * n2;
            case '/' -> {
                if (n2 == 0) {
                    throw new ArithmeticException("除数不能为0！");
                }
                result = n1 / n2;
            }
            case '%' -> {
                if (n2 == 0) {
                    throw new ArithmeticException("除数不能为0！");
                }
                result = n1 % n2;
            }
            default -> System.out.println("暂时不支持此功能！");
        }
        System.out.printf("计算的结果是：%d %c %d = %d \n",n1,op,n2,result);
    }
}
