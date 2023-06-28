package lesson06.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ErrorWithFinally {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(("D:\\java_projects\\test\\JavaOOP\\src\\lesson06\\demo\\readme.txt")));
            StringBuffer sb = new StringBuffer();
            String row;
            while ((row = reader.readLine()) != null) {
                sb.append(row);
                sb.append("\r\n");
            }
            System.out.println(sb);
        }
        catch(Exception ex) {
            ex.printStackTrace(); //输出异常堆栈信息
            System.out.println("读出文件内容错误，错误的信息是：" + ex.getMessage());
        }
        finally {
            System.out.println("释放所有资源======================");
            if(null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //打印异常堆栈信息
                    e.printStackTrace();
                    System.out.println("IO异常！错误消息是：" + e.getMessage());
                }
            }
        }
    }
}
