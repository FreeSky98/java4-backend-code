package org.net2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest {
    //服务器IP
    private static final String SERVER_IP = "127.0.0.1";
    private static final int PORT = 9090;
    private static Scanner input = new Scanner(System.in);
    private static void clientStart(String ip,int port) {
        Socket client;
        try {
            client = new Socket(ip,port);
            System.out.println("成功建立连接...");
            while (true){
                System.out.print("请输入聊天内容：");
                String message = input.next();
                PrintWriter out = new PrintWriter(client.getOutputStream(),true);//打印输出流
                out.println(message);//数据发送给服务器，不使用write和print方法
                if ("exit".equalsIgnoreCase(message)) {
                    break;
                }

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));
                String response = in.readLine();
                System.out.println("响应信息："+response);

            }
        } catch (IOException e) {
            System.out.println("连接目标主机失败，错误信息："+e.getMessage());
        }
    }

    public static void main(String[] args) {
        clientStart(SERVER_IP,PORT);
    }
}
