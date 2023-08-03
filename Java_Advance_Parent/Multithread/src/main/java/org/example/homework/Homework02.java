package org.example.homework;

public class Homework02 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println("第"+i+"次打印main");
        }
        MyRunnable target = new MyRunnable();
        Thread thread = new Thread(target,"新线程");
        thread.start();
    }
}

class MyRunnable implements Runnable {
    public MyRunnable() {

    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("第"+i+"次打印new");
        }
    }
}
