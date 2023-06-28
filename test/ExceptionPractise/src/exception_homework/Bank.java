package exception_homework;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Account a1 = new Account(2000);
        CheckingAccount a2 = new CheckingAccount(1000,5000);
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("请输入存款金额：");
            double depositMoney = input.nextDouble();
            a1.deposit(depositMoney);
        } catch (OverdraftException e) {
            throw new RuntimeException(e);
        }
        System.out.println("存款成功！账户余额"+a1.getBalance()+"元");
        try {
            System.out.print("请输入存款金额：");
            double depositMoney = input.nextDouble();
            a2.deposit(depositMoney);
        } catch (OverdraftException e) {
            throw new RuntimeException(e);
        }
        System.out.println("存款成功！账户余额"+a2.getBalance()+"元");

        try {
            System.out.print("请输入取款金额：");
            double withdrawMoney = input.nextDouble();
            a1.withdraw(withdrawMoney);
        } catch (OverdraftException e) {
            throw new RuntimeException(e);
        }
        System.out.println("取款成功！账户余额"+a1.getBalance()+"元");

        try {
            System.out.print("请输入取款金额：");
            double withdrawMoney = input.nextDouble();
            a2.withdraw(withdrawMoney);
        } catch (OverdraftException e) {
            throw new RuntimeException(e);
        }
        System.out.println("取款成功！账户余额"+a2.getBalance()+"元");
    }

    public static class Account {

        /**
         * 账户类
         */
        protected double balance;

        public Account(double balance) {
            this.balance = balance;
        }

        public Account() {
        }

        public double getBalance() {
            return balance;
        }

        /**
         * 存钱方法
         * @param money 存入金额
         */
        public void deposit(double money) throws OverdraftException {
            if (money < 0) {
                throw new OverdraftException("存款金额不能为负数",0);
            }
            this.balance = balance + money;
        }

        /**
         *
         * @param money 取出金额
         */
        public void withdraw(double money) throws OverdraftException {
            if (money < 0) {
                throw new IllegalArgumentException("存款金额不能为负数");
            }
            else {
                if (money > this.balance) {
                    throw new OverdraftException("账户余额不足！",money - this.balance);
                }
                this.balance = balance - money;
            }
        }
    }

    /**
     * 支票账户
     */
    public static class CheckingAccount extends Account {
        /**
         * 透支额度
         */
        private double overdraftProtection;

        public CheckingAccount(double balance) {
            super(balance);
        }

        public CheckingAccount(double balance,double protect) {
            super(balance);
            this.overdraftProtection = protect;
        }

        /**
         * 获取透支额度方法
         * @return 透支额度
         */
        public double getOverdraftProtection() {
            return overdraftProtection;
        }
        public void withdraw(double money) throws OverdraftException {

            if (money > this.balance && (money - this.balance) < this.overdraftProtection) {
                System.out.println("账户余额不足，此账户为支票账户，您的透支额度为："+getOverdraftProtection());
                this.balance = this.balance + getOverdraftProtection() - money;
            } else if (money > this.balance && (money - this.balance) > this.overdraftProtection){
                throw new OverdraftException("账户余额与透支额度不足！",money - this.balance);
            } else {
                this.balance = this.balance - money;
            }
        }
    }

    /**
     * 透支异常类
     */
    public static class OverdraftException extends Exception{
        /**
         * 透支额
         */
        private double deficit;


        public OverdraftException(String message, double deficit) {
            super(message);
            this.deficit = deficit;
        }

        public double getDeficit() {
            return deficit;
        }
    }
}

