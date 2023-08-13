package org.net3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class AppServer {

    public static void main(String[] args) {
        ServerSocket server;
        try {
            server = new ServerSocket(9090);
            System.out.println("服务器已启动");
            while (true) {
                final Socket socket = server.accept();
                System.out.println(socket.getRemoteSocketAddress() + "已连接");
                while (true) {
                    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    Request request = (Request) ois.readObject();
                    System.out.println("我是服务端，已收到你的信息>>");
                    System.out.println(request.getData().get("loginUser"));
                    Response response = new Response();
                    if (request != null
                            && "login".equalsIgnoreCase(request.getAction())) {
                        Map<String, Object> requestMap = request.getData();
                        User user = (User) requestMap.get("loginUser");
                        if ("admin".equalsIgnoreCase(user.getUserName())
                                && "admin888".equals(user.getPassword())) {
                            response.setSuccess(true);
                            response.setMessage("登录成功，欢迎" + user.getUserName() + "!");
                            response.getData().put("userInfo", user);
                        } else {
                            response.setSuccess(false);
                            response.setMessage("登录失败，用户名或密码错误!");
                        }
                    }
                    oos.writeObject(response);
                    oos.flush();
                }
            }
        } catch (Exception e) {
            System.out.println("服务器启动错误，错误信息: " + e.getMessage());
        }
    }

}
