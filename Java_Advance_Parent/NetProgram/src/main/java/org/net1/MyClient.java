package org.net1;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 开发客户端（测试本地文件上传到文件存储服务器）
 */
public class MyClient {
    //192.168.100.59此IP是服务器的IP地址，而不是你本地客户端IP地，切记
    private static final String HOST  = "192.168.100.59";
    private static final int PORT  = 8888; // 端口是服务器所监听的端口，而不是你本地客户端的端口
    //客户端
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // 从键盘接收用户输入
        Socket client = null;
        try{
            // 创建客户端对象
            client = new Socket(HOST,PORT);
            File upFile = null;
            while (true) {
                System.out.print("请正确输入所上传的文件路径:");
                String filePath = input.next();
                upFile = new File(filePath);
                if(! upFile.exists()) {
                    System.out.println("上传的文件不存在，请检查！");
                }
                else {
                    //获取客户端本地文件转换为字节输入流-----读取操作
                    DataInputStream dis = null;
                    DataOutputStream dos = null;
                    try{
                        dis = new DataInputStream(new FileInputStream(upFile));
                        dos = new DataOutputStream(client.getOutputStream());

                        String fileName = upFile.getName(); //获取上传文件名称
                        long fileSize = upFile.length(); //获取上传文件的大小（以字节为单位）
                        dos.writeUTF(fileName);  // 将文件名称写到服务器
                        dos.writeLong(fileSize);  // 将文件大小写到服务器
                        // 以下发送数据块
                        //创建数据缓冲区
                        byte[] buffer = new byte[1024];  //每次读取1kb大小的数据到字节数组中
                        int len = 0; //每次实际读取的字节数
                        while ((len = dis.read(buffer)) != -1) { // 如果读取文件末尾为-1，终止循环
                            dos.write(buffer,0,len); // 将文件中的数据写入到服务器端
                            dos.flush(); // 强制刷新缓冲区
                        }
                        // TODO: 得到服务器响应信息   （比如： 文件上传成功！）
                    }
                    catch (IOException ex) {
                        System.out.println("出现IO异常，错误信息为：" + ex.getMessage());
                        ex.printStackTrace();
                    }

                    System.out.print("继续上传文件么(Y/N)?");
                    String answer = input.next();
                    if("n".equalsIgnoreCase(answer)){
                        break;
                    }
                }
            }


        }catch (Exception err) {
            err.printStackTrace();
        }

    }
}
