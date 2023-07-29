package demo2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * 导入类
 */
public class ReadFile {
    public static void main(String[] args) {
        //声明文件输入流对象
//        FileInputStream fis = null;
        BufferedReader reader = null;
        try {
            //构建文件输入流对象
            reader = new BufferedReader( //字符流 有临时缓冲区
                    new InputStreamReader( //字节流转字符流
                            new FileInputStream("data/my.txt")),8192);//字节流
            //读取指定文件中的内容,需创建数据缓冲区
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\r\n");
            }
            System.out.println(sb);
//            StringBuilder sb = new StringBuilder();
//            byte[] buffer = new byte[2048];
//            int len = 0;
//            //使用循环读取
//            while ((len = fis.read(buffer,0,buffer.length)) != -1) {
//                System.out.println("每次实际读取字节数len>>>>>>>>>>>>>>>>>>>>>>>" + len);
//                String str = new String(buffer,0,len,StandardCharsets.UTF_8);
//                sb.append(str);
//            }
//            System.out.println("读取内容 = " + sb);


//            int len = fis.available();//从输入流中读取可用的字节数
//            byte[] buffer = new byte[len];//1Kb = 1024byte
//            System.out.println("从输入流中读取可用的字节数是："+len);
//            fis.read(buffer);
//            String str = new String(buffer, StandardCharsets.UTF_8);
//            System.out.println("读取的内容是："+str);
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
