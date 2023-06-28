import java.util.Scanner;

public class If_ElseDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入用户名： ");
        String username = input.next();
        System.out.print("请输入登录密码： ");
        int password = input.nextInt();
        if ("admin".equals(username) && 123456 == password) {
            System.out.println("登陆成功，欢迎您！");
        }
        else {
            System.err.println("用户名或密码错误！");
        }
    }
}
