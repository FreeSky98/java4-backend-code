package org.example.demo2;

public class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }

    public void run(){
        String curThreadName = this.getName();
        System.out.println("当前线程名为" + curThreadName);
        int evenSum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                evenSum += i;
            }
            System.out.println("当前线程名为" + curThreadName+",1~100的偶数和为"+evenSum);
        }
        System.out.println("1~100的偶数和为"+evenSum);
    }
}
