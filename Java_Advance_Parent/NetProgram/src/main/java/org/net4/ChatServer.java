package org.net4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
    // 服务器监听端口
    private static final int SERVER_PORT = 8080;
    // 保存客户机集合
    private static final List<Socket> socketList = new CopyOnWriteArrayList<>();
    // 当前的客户机
    private static Socket currentSocket = null;

    // 创建线程池对象
   private static final ExecutorService executorService = Executors.newFixedThreadPool(26);


    //服务器启动方法
    public static void start(int port) {
        // 申明一个服务器套接字
        ServerSocket chatServer = null;
        try {
            chatServer = new ServerSocket(port);
            System.out.println("聊天室服务已启动");
            while (true) {
                currentSocket = chatServer.accept();
                // 将刚成功与服务器连接的客户机添加集合中
                socketList.add(currentSocket);
                // getRemoteSocketAddress()获取远程客户机的IP地址和端口
                System.out.println(currentSocket.getRemoteSocketAddress()+"已加入聊天室，当前在线总人数" + socketList.size());

                // 为每一个成功连接到服务器的客户机，专门开启一个工作线程服务
                //通过线程池对象创建新的工作线程
                executorService.submit(new ServerHandlerTask(currentSocket,socketList));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //启动服务器
        start(SERVER_PORT);
    }

}
