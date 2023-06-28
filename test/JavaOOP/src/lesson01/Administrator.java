package lesson01;

import java.util.Scanner;

public class Administrator {
    String username = "admin";
    String password = "admin123";

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}

class AdminTest {
    public static void main(String[] args) {
        Administrator adminUser = new Administrator();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = input.next();
        System.out.println("请输入密码：");
        String password = input.next();
        if (adminUser.login(username, password)) {
            System.out.println("请输入新密码：");
            adminUser.password = input.next();
            System.out.println("修改密码成功，您的新密码为：" + adminUser.password);
        } else {
            System.out.println("用户名和密码不匹配！您没有权限更新管理员信息。");
        }
    }
}
