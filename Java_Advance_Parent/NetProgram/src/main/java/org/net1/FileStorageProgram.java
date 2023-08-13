package org.net1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件存储服务器
 */
public class FileStorageProgram {

    private static final int SERVER_POST = 8888;//定义端口
    public static void main(String[] args) {
        ServerSocket fileServer = null;
        try {
            fileServer = new ServerSocket(SERVER_POST);
            System.out.println("文件存储服务器已启动...");
            for (;;) {
                final Socket s = fileServer.accept();//accept()接受客户端的连接请求，是阻塞方法
                String remoteIP = s.getInetAddress().getHostAddress();//获得远程客户端IP地址
                int remotePort = s.getPort();//获取远程客户端端口
                int localPort = s.getLocalPort();//获取本地端口
                System.out.println("远程客户端IP地址："+remoteIP+"，远程客户端端口："+remotePort);

                //实现客户端将本地文件上传到服务器上某个指定文件夹中保存。

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (fileServer != null) {
                try {
                    fileServer.close();
                    System.out.println("服务器已经关闭！");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
