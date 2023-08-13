package org.net3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class AppClient {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Socket socket;
        try {
            socket = new Socket("127.0.0.1",9090);
            System.out.println("+++++++++++用户登录++++++++++++");
            while (true) {
                System.out.print("请输入用户名:");
                String userName = input.next();
                System.out.print("请输入密码:");
                String password = input.next();
                User user = new User();
                user.setUserId(1240);
                user.setUserName(userName);
                user.setUserType("0");
                user.setPassword(password);
                user.setPhoneNumber("15324498270");
                Request request = new Request();
                request.setAction("login");
                request.getData().put("loginUser",user);
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                oos.writeObject(request);
                oos.flush();

                Response response = (Response) ois.readObject();
                if (response.isSuccess()) {
                    System.out.println(response.getMessage());
                    System.out.println(response.getData().get("userInfo").toString());
                }
                else {
                    System.out.println(response.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
