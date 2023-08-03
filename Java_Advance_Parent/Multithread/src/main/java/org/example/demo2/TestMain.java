package org.example.demo2;

public class TestMain {
    public static void main(String[] args) {
        //创建两个线程（A、B）
        MyThread threadA = new MyThread("线程A");
        MyThread threadB = new MyThread("线程B");

        //设置优先级
        threadA.setPriority(Thread.MAX_PRIORITY);
        threadB.setPriority(Thread.MIN_PRIORITY);

        //分别启动两个线程，不可以用run()方法，run是单线程
        threadA.start();
        threadB.start();
    }
}
