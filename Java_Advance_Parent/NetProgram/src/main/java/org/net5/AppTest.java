package org.net5;


public class AppTest {
    public static void main(String[] args) {
        DownloadVideoThread targetA = new DownloadVideoThread("https://www.ku6.com/video/feed?pageNo=0&pageSize=40", "D:/videos_1");

//        DownloadVideoThread targetB = new DownloadVideoThread("https://www.ku6.com/video/feed?pageNo=1&pageSize=40", "D:/videos_2");
//
//        DownloadVideoThread targetC = new DownloadVideoThread("https://www.ku6.com/video/feed?pageNo=2&pageSize=40", "D:/videos_3");

        Thread tA = new Thread(targetA,"下载任务-1");
//        Thread tB = new Thread(targetB,"下载任务-2");
//        Thread tC = new Thread(targetC,"下载任务-3");

        tA.start();
//        tB.start();
//        tC.start();
    }
}
