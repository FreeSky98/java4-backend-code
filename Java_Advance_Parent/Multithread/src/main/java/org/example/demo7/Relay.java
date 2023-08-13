package org.example.demo7;

public class Relay {
    public static void main(String[] args) {
        RunThread target = new RunThread();
        for (int i = 1; i <= 10; i++) {
            new Thread(target, "第" + i + "位选手").start();
        }
    }
}

class RunThread implements Runnable {
    public static int meter = 1000;

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "拿到接力棒");
            for (int j = 10; j <= 100; j += 10) {
                meter -= 10;
                System.out.println(Thread.currentThread().getName() + "跑了" + j + "米,还剩下"+ meter + "米");
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
