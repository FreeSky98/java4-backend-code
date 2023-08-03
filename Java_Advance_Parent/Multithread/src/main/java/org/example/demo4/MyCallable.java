package org.example.demo4;

import java.util.concurrent.Callable;

//第三种创建线程方式：通过Callable<T>和FutureTask<T>实现的
//
//第一步：定义一个实现Callable<V>接口实现类MyCallable
public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 100; i++) {
            sum += i;
            System.out.println("当前线程【"+Thread.currentThread().getName()+"】"+sum);
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end-start) + "(ms)");
        return sum;
    }
}
