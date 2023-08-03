package org.example.demo4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {
    public static void main(String[] args) {
        //第二步：创建Callable接口的实现类的对象
        MyCallable myCallable = new MyCallable();
        //第三步：将此Callable接口实现类的对象作为参数传递到FutureTask的构造器中，创建FutureTask的对象
        FutureTask<Integer> task = new FutureTask<>(myCallable);
        //第四步：将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread threadA = new Thread(task,"线程A");
        //第五步：通过Thread类的对象调用start()启动线程
        threadA.start();

        try {
            Integer sum = task.get();//阻塞方法，一直等待到线程执行结束后才能获得结果
            System.out.println("sum = " + sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
