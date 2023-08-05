package org.example.demo5;

import java.util.concurrent.TimeUnit;

public class PractiseTest {
    public static void main(String[] args) {
        Thread older = new Thread(new ClimbThread(1500,1400),"老年人");
        Thread young = new Thread(new ClimbThread(1000,1400),"青年人");
        older.start();
        young.start();
    }
}

//线程类
class ClimbThread implements Runnable{
    /**
     * 爬100米时长（ms为单位）老年人1500ms=1.5s  青年人：1000ms=1s
     */
    private long time;
    private int meter;


    public ClimbThread(long time, int meter) {
        this.time = time;
        this.meter = meter;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getMeter() {
        return meter;
    }

    public void setMeter(int meter) {
        this.meter = meter;
    }

    @Override
    public void run() {
        for (int i = 100; i <= this.meter ; i+= 100) {
            System.out.printf("【%s】爬完了%d米！%n",Thread.currentThread().getName(),i);
            try {
                //Thread.sleep(this.time);
                TimeUnit.MILLISECONDS.sleep(this.time); //模拟每次爬100米需要的耗时
            } catch (InterruptedException e) {
                e.printStackTrace();//被其他线程中断，输出异常堆栈信息
            }
        }
        System.out.printf("恭喜【%s】已到达上顶！%n",Thread.currentThread().getName());
    }
}
