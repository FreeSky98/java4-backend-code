import java.util.Scanner;

public class Practise03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("拨打10086电话：");
        int num = input.nextInt();
        switch (num) {
            case 1 -> System.out.println("业务办理");
            case 2 -> System.out.println("话费查询");
            case 3 -> System.out.println("余额查询");
            case 4 -> System.out.println("宽带业务");
            case 0 -> System.out.println("人工服务");
            default -> System.out.println("输入错误，请重新选择！");
        }
    }
}
