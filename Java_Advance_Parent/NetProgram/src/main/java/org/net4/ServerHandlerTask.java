package org.net4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

/**
 * 服务器端线程处理类
 *   1、接收某个客户机发送过来的信息
 *   2、立即将某个客户机发送过来的信息，分发（广播）给每个客户机。
 */
public class ServerHandlerTask implements Runnable {
    // 当前发送信息过来的客户机
    private final Socket client;
    // 客户机集合
    private final List<Socket> socketList;
    public ServerHandlerTask(final Socket currentSocket, List<Socket> socketList) {
        this.client = currentSocket;
        this.socketList = socketList;
    }

    @Override
    public void run() {
        //线程执行体
        try {
            BufferedReader reader = null;
            while (true){
                reader = new BufferedReader(
                        new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8));
                //读取客户机发送过来的信息
                String message = reader.readLine();
                // 将信息分发给所有的客户机
                sendMsgToAll(message);
            }
        } catch (IOException e) {
            System.out.println("11111111111111111111111111111111111111>>>>>>>>>>>>>>");
            e.printStackTrace();
            System.out.println(client.getRemoteSocketAddress()+"客户机与服务器已断开连接");
            socketList.remove(client);
            System.out.println("当前聊天室在线总人数为：" + this.socketList.size());
            if(this.client != null && this.client.isClosed() == false) {
                try {
                    this.client.close();
                } catch (IOException ex) {
                   ex.printStackTrace();
                }
            }
        }
    }

    // 将信息分发给所有的客户机
    private void sendMsgToAll(String message) {
        LocalDateTime sendTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        message = "【"+client.getRemoteSocketAddress()+"】客户端："+message+"/"+formatter.format(null);
        PrintWriter out = null;
        //排除掉当前发送信息过来的客户机
        for (Socket socket : this.socketList) {
            if(Objects.equals(socket,client) == true) {
                continue; //如果条件成立，说明排除自己，继续下一次循环(跳过自己不发送信息)
            }
            // socket表示每个客户机
            try {
                out = new PrintWriter(socket.getOutputStream(),true);
                out.println(message); // 发送消息给所有客户机
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("2222222222222222222222222222222222==================");
                /*System.out.println(socket.getRemoteSocketAddress()+"客户机与服务器已断开连接");
                socketList.remove(socket);
                System.out.println("当前聊天室在线总人数为：" + this.socketList.size());
                if(socket != null && socket.isClosed() == false) {
                    try {
                        socket.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }*/
            }
        }
    }
}
