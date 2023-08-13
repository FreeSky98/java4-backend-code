package org.example.demo6;

public class SynchLock {
    //同步实例方法1
    public synchronized void synchMethod1(){

        for (int i = 0; i < 10; i++) {
            System.out.println("我是同步实例方法1>>>>>>>>>>>i" + i);
        }
    }
    //同步实例方法2
    public synchronized void synchMethod2(){
        for (int i = 0; i < 20; i++) {
            System.out.println("我是同步实例方法2>>>>>>>>>>>i" + i);
        }
    }

    //同步静态方法1
    public synchronized static void synchStaticMethod1(){
        System.out.println("我是同步静态方法1");
    }
    //同步静态方法2
    public synchronized static void synchStaticMethod2(){
        System.out.println("我是同步静态方法2");
    }

    public static void main(String[] args) {
        /*
        在某个对象实例内，synchronized aMethod(){}可以防止多个线程同时访问这个对象的同步方法(如果一个对象有多个同步方法，只要一个线程访问了其中的一个同步方法，其他线程不能同时访问这个对象中任何一个同步方法)。


         */
        SynchLock obj = new SynchLock();
        new Thread(() -> {
            obj.synchMethod2();
        },"线程-2").start();


        new Thread(() -> {
            obj.synchMethod1();
        },"线程-1").start();

        new Thread(() -> {
            new SynchLock().synchStaticMethod1();
        },"线程-1").start();

        new Thread(() -> {
            new SynchLock().synchStaticMethod2();
        },"线程-2").start();


    }
}
