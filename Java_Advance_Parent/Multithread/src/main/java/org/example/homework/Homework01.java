package org.example.homework;

public class Homework01 extends Thread{
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("线程1");
        MyThread thread2 = new MyThread("线程2");
        thread1.start();
        thread2.start();
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        String name = this.getName();
        System.out.println("当前线程名："+name);
    }
}
