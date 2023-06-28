package lesson02;

import java.util.Scanner;

public class BankAccount {
    private int account;
    private int password;
    private double money;//存款余额
    static double rate = 0.025;//利率
    static double minMoney = 0.01;//最小余额
    public static int INCREMENT = 1001;
    static Scanner input = new Scanner(System.in);

    public BankAccount(int password, double money) {
        this.password = password;
        this.money = money;
    }
    public BankAccount() {}

    {
        account = INCREMENT;
        System.out.println("账号为："+ account);
        INCREMENT++;
    }

    public int getAccount() {
        return account;
    }


    public int getPassword() {
        return password;
    }

    public void setPassword() {
        System.out.println("请输入新用户密码：");
        int password = input.nextInt();
        if (password >= 111111 && password <= 999999) {
            this.password = password;
        }
        else {
            System.out.println("密码必须是六位数字！");
        }
    }

    public double getMoney() {
        return money;
    }

    public void setMoney() {
        System.out.println("请输入存款余额：");
        this.money = input.nextInt();
    }

    public String toString() {
        return "账号"+getAccount()+",密码"+getPassword()+",存款余额"+getMoney()+",年利率"+rate+",最小余额"+minMoney;
    }
}

class BankTest {
    public static void main(String[] args) {
        BankAccount admin1 = new BankAccount();
        admin1.setPassword();
        admin1.setMoney();
        System.out.println(admin1);

        BankAccount admin2 = new BankAccount();
        admin2.setPassword();
        admin2.setMoney();
        System.out.println(admin2);

        BankAccount admin3 = new BankAccount();
        admin3.setPassword();
        admin3.setMoney();
        System.out.println(admin3);

    }
}
