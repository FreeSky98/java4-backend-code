package org.example.demo6;

public class NetTicket implements Runnable {
    //共享数据票数=100
    //多线程共享数据会有问题，需要加锁
    private static int count = 100;
    private static int no = 0;//票号
    private boolean flags = false;

    public static void main(String[] args) {
        NetTicket target = new NetTicket();
        Thread t1 = new Thread(target, "第一站台点");
        Thread t2 = new Thread(target, "第二站台点");
        t1.start();
        t2.start();
    }

    synchronized void sellTicket() {//方法上锁
        if (count <= 0) {
            flags = true;
            System.out.println("票已售罄！");
            return;
        }
        count--;
        no++;
        String name = Thread.currentThread().getName();
        System.out.println(name + "成功抢到第" + no + "张票，还剩余" + count + "张票。");

//        synchronized (this) {
//            //共享数据上锁
//            System.out.println(Thread.currentThread().getName() + "已获得锁！！！");
//                        // 保证线程安全，上锁
//                        count--;
//                        no++;
//                        if(count <= 0) {
//                            System.out.println("票已售完，售票入口已关闭！！");
//                            break; //退出死循环
//                        }
//                        else {
//                            System.out.println(Thread.currentThread().getName()
//                                    + "抢到第" + no + "张票，剩余" + count + "张票！");
//                            System.out.println(Thread.currentThread().getName() + "已解锁");
//                        }
//        }
    }

    @Override
    public void run() {
        while (!flags) {
            /* sleep()方法
             *   sleep()方法在持有锁或不持有锁执行，不会释放对象锁资源
             * */
            try {
                Thread.sleep(20); //模拟网络延时
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sellTicket();
        }
    }
}
