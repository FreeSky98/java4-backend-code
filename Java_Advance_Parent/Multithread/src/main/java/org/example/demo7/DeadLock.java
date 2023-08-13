package org.example.demo7;

/**
 * 模拟死锁例子
 */
public class DeadLock implements Runnable {
    //共享资源A
    private static final Object resA = new Object();
    //共享资源B
    private static final Object resB = new Object();

    //标记变量
    private boolean flag = false;

    public DeadLock(boolean _flag) {
        flag = _flag;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadLock(true), "线程-1");
        Thread t2 = new Thread(new DeadLock(false), "线程-2");

        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (resA) {
                System.out.println(Thread.currentThread().getName() + "已锁住resA");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resB) {
                    // 执行不到这里
                    System.out.println(Thread.currentThread().getName() + "已锁住resB");
                }
            }
        } else {
            synchronized (resB) {
                System.out.println(Thread.currentThread().getName() + "已锁住resB");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resA) {
                    // 执行不到这里
                    System.out.println(Thread.currentThread().getName() + "已锁住resA");
                }
            }
        }
    }
}
