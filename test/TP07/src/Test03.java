import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String button;
        do {
            System.out.print("请输入第一个数：");
            double x1 = input.nextDouble();
            System.out.print("请输入运算符：");
            String op = input.next();
            System.out.print("请输入第二个数：");
            double x2 = input.nextDouble();
            double result = 0.0;
            switch (op) {
                case "+" -> result = x1 + x2;
                case "-" -> result = x1 - x2;
                case "*" -> result = x1 * x2;
                case "/" -> {
                    if (x2 == 0) {
                        System.out.println("除数不能为0！");
                    }
                    result = x1 / x2;
                }
                default -> System.out.println("暂时不支持此功能");
            }
            System.out.println(x1 + op + x2 + "=" + result);
            System.out.print("是否继续？Y：继续，任意字符：结束");
            button = input.next();

        } while ("Y".equalsIgnoreCase(button));
    }
}
