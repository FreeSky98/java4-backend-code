package org.example.homework;

class Account {
    private int balance;//余额

    public Account() {
        balance = 0;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("当前账户余额：" + balance);
    }
}

class Depositor implements Runnable {
    private Account account;
    private String depositorName;

    public Depositor(Account account, String depositorName) {
        this.account = account;
        this.depositorName = depositorName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            account.deposit(100);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Homework04 {
    public static void main(String[] args) {
        Account account = new Account();
        Depositor depositor1 = new Depositor(account, "储户1");
        Depositor depositor2 = new Depositor(account, "储户2");

        Thread thread1 = new Thread(depositor1);
        Thread thread2 = new Thread(depositor2);

        thread1.start();
        thread2.start();
    }
}