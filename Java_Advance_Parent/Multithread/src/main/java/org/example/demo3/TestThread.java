package org.example.demo3;

public class TestThread {
    public static void main(String[] args) {
        MyRunnable target = new MyRunnable();

        Thread t1 = new Thread(target,"线程-1");
        Thread t2 = new Thread(target,"线程-2");

        t1.start();
        t2.start();
    }
}
