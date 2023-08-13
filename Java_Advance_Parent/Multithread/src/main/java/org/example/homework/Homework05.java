package org.example.homework;

public class Homework05 {
    //设计一个多线程的程序如下：设计一个火车售票模拟程序。
    //假如火车站要有100张火车票要卖出，现在有5个售票点同时售票，用5个线程模拟这5个售票点的售票情况。
    public static void main(String[] args) {
        TrainTicketRunnable target = new TrainTicketRunnable();
        for (int i = 1; i <= 5; i++) {
            Thread terminal = new Thread(target, "第" + i + "售票点");
            terminal.start();
        }
    }
}

class TrainTicketRunnable implements Runnable {
    public static int ticket = 100;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            synchronized (this) {
                if (ticket > 0) {
                    ticket -= 1;
                    System.out.println(Thread.currentThread().getName() + "售出1张票，剩余" + ticket + "张票");
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + ":今日火车票已售罄！");
                    break;
                }
            }
        }
    }
}
