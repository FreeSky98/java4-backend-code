package org.example.demo2;

import java.io.IOException;

public class MainThread {

    public static void main(String[] args) throws IOException {
        //Thread静态方法currentThread()获取当前线程对象
        Thread main = Thread.currentThread();
        System.out.println("主线程名更改前："+main.getName());
        main.setName("更改咯OvO =b");

        System.out.println("主线程名更改后："+main.getName());
        System.out.println("主线程名优先级："+main.getPriority());
        System.out.println("主线程名标识符ID："+main.getId());
        System.out.println("主线程名状态："+main.getState());

        System.out.println("等待输入...");
        System.in.read();
    }
}
