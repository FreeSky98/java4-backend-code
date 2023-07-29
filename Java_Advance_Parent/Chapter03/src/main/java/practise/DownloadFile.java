package practise;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFile {
    private static final String VIDEO_URL = "https://v26-web.douyinvod.com/9ea9497cb3211b7da787273aec23086e/64c396e2/video/tos/cn/tos-cn-ve-15c001-alinc2/oAXrEvNeLAQZ53zJAigflYTOINQbyYhBjQMEDA/?a=6383&ch=0&cr=0&dr=0&er=0&cd=0%7C0%7C0%7C0&cv=1&br=1302&bt=1302&cs=0&ds=4&ft=bvTKJbQQqUCIf_EZPo0OW_EklpPiXjcHYMVJE9CkXlbPD-I&mime_type=video_mp4&qs=1&rc=Ozc4OmQ4ZjVkNGU4MzhlNUBpajhmcjc6ZmZsbTMzNGkzM0A0YWM0Y2JfXl8xMmAzYF4wYSNrZ29wcjQwYC5gLS1kLWFzcw%3D%3D&l=202307281718520D6DDFDFAA38A6027728&btag=e00028000&dy_q=1690535932";
    //从网络上下载视频（通过数据输入和输出流实现）
    private static long fileLength = 0L;

    public static InputStream getInputStream(String videoURL) throws IOException {
        // 创建网址对象
        URL url = new URL(videoURL);
        // 构建HTTP连接对象
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        fileLength = httpConn.getContentLength(); //获取文件大小
        System.out.println("文件总大小" + fileLength);
        // 通过HTTP连接对象获取输入流
        if (httpConn.getResponseCode() == 200) {
            return httpConn.getInputStream();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("正在下载视频，请稍后 ...");
        try (
                //创建数据输入流对象
                InputStream is = getInputStream(VIDEO_URL);
                DataInputStream dis = new DataInputStream(is);
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("data/123.mp4"));
        ) {
            byte[] bytes = new byte[1024];
            int len = 0; // 每次读取的字节数
            int byteSum = 0; //统计总的字节数
            while ((len = dis.read(bytes)) > 0) {
                byteSum += len; //累加实际读取字节数

                dos.write(bytes, 0, len);
                dos.flush();

                if (byteSum == fileLength) {
                    System.out.println("视频下载完成：100%");
                    break;
                } else {
                    System.out.printf("已经下载了：%.0f %% \n", ((int) (float) byteSum / (float) fileLength * 100));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}