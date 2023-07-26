package com.study.demo5;

import cn.hutool.core.date.StopWatch;

public class StringBufferDemo {
    public static final int TIMES = 50000;

    public static void testStr() {
        StopWatch stopWatch = new StopWatch("字符串拼接");
        stopWatch.start("拼接总耗时任务：");
        String str = "";
        for (int i = 0; i < TIMES; i++) {
            str += "我爱你祖国";
        }
        stopWatch.stop();
        System.out.println("总耗时：" + stopWatch.getTotalTimeMillis() + "(s)");
    }

    public static void testStrBuf() {
        StopWatch stopWatch = new StopWatch("字符串拼接");
        stopWatch.start("String类字符串拼接总耗时任务");
        //long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TIMES; i++) {
            sb.append("我爱您祖国");
        }
        stopWatch.stop();
        //long endTime = System.currentTimeMillis();
        System.out.println("总耗时：" + stopWatch.getTotalTimeMillis() + "(ms)");
        //long elapsedTime = endTime - startTime;
        // System.out.println("总耗时：" + elapsedTime + "(ms)");
    }

    public static void main(String[] args) {
        testStr();
        testStrBuf();
    }
}
