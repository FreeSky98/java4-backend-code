package org.example.demo5;

public class JoinTest {
    public static void main(String[] args) {
        //Join()加入的线程必须执行完成，阻塞当前线程执行
        Thread joinT = new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                System.out.println("\t"+Thread.currentThread().getName() + "运行:" + i);
            }
        },"子线程");
        joinT.start();

        for (int i = 1; i <= 20; i++) {
            if (i == 5) {
                try {
                    joinT.join();//加入的线程强制执行结束
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + "运行:" + i);
        }
    }
}
