package org.net4;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClient {
    // 服务器IP地址
    private static final String SERVER_IP_ADDR = "192.168.100.58";
    // 服务器进程所占的端口号
    private static final int SERVER_PORT  = 8080;

    public static void main(String[] args) {
        // 申明一个客户机
        //Socket client = null;
        try {
            // 创建客户机对象
            final Socket client = new Socket(SERVER_IP_ADDR,SERVER_PORT);
            // 创建接收服务器响应消息的线程,并启动线程
            new Thread(() -> {
                //TODO:线程执行体 run()方法体具体实现
                try {
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(client.getInputStream()));
                    String line = null;
                    while ((line = reader.readLine()) != null) {  // 网络对网络 ，无法读取null值，相当于死循环
                        System.out.println(line); // 服务器给客户端的响应信息
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }, "【接收消息的工作线程】").start();

            //创建发送消息给服务器的线程,并启动线程

            new Thread(() -> {
                //TODO:线程执行体 run()方法体具体实现
                //BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                Scanner scanner =  new Scanner(System.in);
                try {
                    PrintWriter out = null;
                    for (; ; ) {
                        //String message = input.readLine(); //接收用户在键盘上的输入
                        String line = scanner.nextLine();
                        out = new PrintWriter(client.getOutputStream(),true);
                        out.println(line);
                        out.flush();
                    }
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }, "【发送消息的工作线程】").start();
        } catch (IOException err) {
            // 打印异常堆栈信息
            err.printStackTrace();
        }

    }
}