package org.example.demo3;

import java.util.stream.LongStream;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        //Long sum = LongStream.rangeClosed(0L, 1000L).parallel().sum();
        long sum = 0L;
        for (long i = 0L; i <= 1000000L; i++) {
            sum += i;
            System.out.println("当前线程【"+Thread.currentThread().getName()+"】"+sum);
        }

        long end = System.currentTimeMillis();
        System.out.println("耗费的时间为: " + (end - start) + "ms");
    }
}
