package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器入口方法
 */
public class Server {
    public static void main(String[] args) {

    }

    public void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(Init.getProperty("socket.server.port")));
            System.out.println("服务器启动成功！");
            Socket socket = serverSocket.accept();
            System.out.println("客户端："+socket.getInetAddress()+"获取了链接");

            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
