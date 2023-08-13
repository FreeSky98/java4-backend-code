package org.net5;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler {
    //1.根据正确的URL爬取数据（第一步）
    public static String getDataByURL(String urlString,String charsetName) {
        StringBuffer sb = new StringBuffer();
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        try {
            //构建一个URL对象
            URL url = new URL(urlString);
            // 打开与服务器连接通道
            conn = (HttpURLConnection)url.openConnection();
            if(conn.getResponseCode() == 200) {
                // 使用缓冲字符流读取服务器响应json格式数据
                reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), charsetName));
                // 循环读取网络上数据
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line)
                            .append(System.lineSeparator());
                }
                return sb.toString();
            }
            else {
                return null;
            }
        } catch (MalformedURLException e) {
            System.out.println("你指定URL地址有误,请检查！");
        } catch (IOException e) {
            System.out.println("无法访问服务器，请检查网络配置！");
        } catch (Exception err) {
            System.out.println("出现系统错误，发生错误的原因为：" + err.getMessage());
        } finally {
            // 释放资源
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null) {
                conn.disconnect(); //断开连接
            }
        }
        return null;
    }
    //2.根据爬取下来的数据进行数据解析（第二步）

    //3.数据解析出来之后，数据存储（数据库、txt文件等）（第三步）
    public static void main(String[] args) {
       String title = ":花木兰?动画*导\"演为<   谷爱凌设>计动/画\\";
        String str = filterTitle(title);
        System.out.println(str);
    }


    public static String filterTitle(String title){
        //  \/:*?"<>|
        Pattern pattern = Pattern.compile("[\\s\\\\/:\\*\\?\\\"<>\\|]");
        Matcher matcher = pattern.matcher(title);
        title = matcher.replaceAll(""); // 将匹配到的非法字
        return title;
    }
    public static void saveVideo(File destFile,String videoPath) {
        URLConnection conn;
        BufferedInputStream bis;
        BufferedOutputStream bos;
        try {
            URL url = new URL(videoPath);
            //HttpURLConnection 是 Java 标准库中用来发送 HTTP 请求和接收 HTTP 响应的类。
            conn = url.openConnection();
            bis = new BufferedInputStream(conn.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream(destFile));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) { // 一边读网络上数据，一边写到本地指定目录中
                bos.write(buffer, 0, len);
                bos.flush();
            }
            System.out.println(destFile.getName() + "视频下载完毕！！！");
        } catch (MalformedURLException e) {
            System.out.println("视频下载URL地址错误，请检查！");
        } catch (IOException e) {
            System.out.println("连接服务器失败，请检查网络！");
        }
    }
}
