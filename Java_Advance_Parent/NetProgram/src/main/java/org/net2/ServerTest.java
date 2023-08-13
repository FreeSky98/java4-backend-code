package org.net2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 1.实现两个主机（客户端与服务器）点对点通信（纯文本形式交流--字符流）
 * 2.实现两个主机（客户端与服务器）点对点通讯（网络发送对象--对象流）
 * 3.实现群聊功能
 */
public class ServerTest {
    private static final int PORT = 9090;//服务器监听端口 最好是PORT>=1024 && POST<=49151
    private static Scanner input = new Scanner(System.in);
    private static void start(int port) {
        ServerSocket localServer;
        try {
            localServer = new ServerSocket(port);
            System.out.println("本地服务器已启动！监听端口号："+port+"中，等待客户端连接请求！");
            while (true){
                final Socket host = localServer.accept();
                InetAddress ia = host.getInetAddress();
                int remotePort = host.getPort();
                System.out.println("收到"+ia.getHostAddress()
                        +":"+remotePort+"请求");
                for (;;){
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(host.getInputStream()));
                    String line = in.readLine();
                    System.out.println(line);
                    if ("bye".equalsIgnoreCase(line) || line == null) {
                        break;
                    }
                    System.out.print("回复内容：");
                    PrintWriter out = new PrintWriter(host.getOutputStream(),true);
                    String answer = input.next();
                    out.println(answer);
                }
            }
        } catch (IOException e) {
            System.out.println("本地服务器启动失败或服务器意外终止，错误信息：" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        start(PORT);
    }
}
