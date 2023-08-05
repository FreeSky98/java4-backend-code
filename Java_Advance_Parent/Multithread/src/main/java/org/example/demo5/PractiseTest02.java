package org.example.demo5;

public class PractiseTest02 {
    public static void main(String[] args) {
        Thread.currentThread().setName("普通号");
        Thread vip = new Thread(new VipThread(),"特需号");
        vip.start();
        for (int i = 1; i <= 50; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i+"号病人正在看病");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);//优先级最低
            if (i >= 10) {
                try {
                    vip.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

/**
 * 特需号类
 */
class VipThread implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i+"号病人正在看病");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);//优先级最高
        }
    }
}
