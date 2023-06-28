package lesson06.demo;

import java.util.Scanner;

public class Account {
    private double balance = 500;


    //查询余额
    public double getBalance() {
        return this.balance;
    }

    //取款
    public void withdraw (double money) throws Exception{
        if(money <= 0) {
            throw new IllegalArgumentException("非法金额！");
        }
        if(money > this.balance) {
            throw new NotEnoughMoneyException("余额不足！");
        }
        this.balance -= money;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Account account = new Account();
        try {
            System.out.println("请输入收购金额：");
            int money = input.nextInt();
            account.withdraw(money);
            System.out.println("当前账号余额是：" + account.getBalance());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("出现错误：" + e.getMessage());
        }
    }

}

