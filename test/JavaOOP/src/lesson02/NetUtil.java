package lesson02;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;

public class NetUtil {
    public static void downloadFile(String fileUrl){
        String saveDir = "D:\\java84_fullstack\\JavaOOP\\Lesson-04\\images\\";
        //将文件下载后保存在E盘，返回结果为下载文件大小
        long size = HttpUtil.downloadFile(fileUrl, FileUtil.file(saveDir));
        System.out.println("下载文件大小是: " + (size / 1024) + "(kb)");
    }


    public static void main(String[] args) {
        String imgSrc = "http://img62.ddimg.cn/2023/5/31/2023053109235346780.jpg";
        downloadFile(imgSrc);
    }
}
