package org.example.demo6;

import java.util.concurrent.locks.ReentrantLock;

public class ReentranstTest implements Runnable {
    final static ReentrantLock lock = new ReentrantLock();
    /////////////////////////共享数据/////////////////////
    private int count = 10; // 记录剩余票数
    private int num = 0; // 记录买到第几张票

    ///////////////////////////////////////////////////
    @Override
    public void run() {
        // 创建一个可重入锁对象   Reentrant(可重入的或可再入的) Lock（锁）
        while (true) {
            lock.lock(); //上锁
            System.out.println(Thread.currentThread().getName() + "已上锁！！！");
            try {
                // 没有余票时，跳出循环
                if (count <= 0) {
                    break;
                }
                // 第一步：修改数据
                num++;
                count--;
                // 第二步：显示信息
                System.out.println(Thread.currentThread().getName() + "抢到第"
                        + num + "张票，剩余" + count + "张票！");
            } finally {
                System.out.println(Thread.currentThread().getName() + "已解锁！！！");
                lock.unlock(); //解锁
            }
            try {
                Thread.sleep(500); // 模拟网络延时
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ReentranstTest target = new ReentranstTest();
        Thread t1 = new Thread(target, "第一站台点");
        Thread t2 = new Thread(target, "第二站台点");
        t1.start();
        t2.start();
    }
}
