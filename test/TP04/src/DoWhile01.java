import java.util.Scanner;

public class DoWhile01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name;
        do {
            System.out.print("请输入学生姓名：");
            name = input.next();
            System.out.println("学生姓名：" + name);
        } while (!"q" .equalsIgnoreCase(name));
    }
}
