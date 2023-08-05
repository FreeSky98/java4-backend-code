package org.example.demo5;

public class SleepTest {
    public static void bySec(long s) {
        for (int i = 0; i < s; i++) {
            System.out.println(i + 1 + "秒");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        bySec(10L);
    }
}

