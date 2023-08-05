package org.example.demo5;

@FunctionalInterface
interface Calculator {
    int sum(int x,int y);
}
public class ThreadPriorityTest {
    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                System.out.println(Thread.currentThread().getName()+"正在运行："+i);
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "线程A");
        a.setPriority(Thread.MIN_PRIORITY);
        a.start();

        Thread b = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                System.out.println(Thread.currentThread().getName()+"正在运行："+i);
            }
        }, "线程B");
        b.setPriority(Thread.MAX_PRIORITY);
        b.start();
    }
}
