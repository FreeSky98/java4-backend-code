package org.example.demo1;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.StreamProgress;
import cn.hutool.http.HttpUtil;

import java.io.File;

public class DownloadFile extends Thread{
    private String fileUrl;//下载地址
    private File destFile;//存储位置目录

    public DownloadFile(String fileUrl,File destFile) {
        this.fileUrl = fileUrl;
        this.destFile = destFile;
    }

    @Override
    public void run() {
        //TODO:编写下载文件逻辑代码
        HttpUtil.downloadFile(this.fileUrl, this.destFile, new StreamProgress() {
            /**
             *
             */
            @Override
            public void start() {
                System.out.println("开始下载文件中，请稍后 ...");
            }

            /**
             *   * @param total        总大小，如果未知为 -1或者{@link Long#MAX_VALUE}
             *                      * @param progressSize 已经进行的大小
             */
            @Override
            public void progress(long total, long progressSize) {
                String message = FileUtil.readableFileSize(progressSize);
                System.out.println("已下载："+message);
                double ratio = (int)(progressSize*1.0/total)*100;
                System.out.println("已下载："+ratio+"%");
            }

            /**
             *
             */
            @Override
            public void finish() {
                //https://sys-140-0.576360.com/windows/jj/nn/202308a/G_WIN10_X32_V2023.iso
                System.out.println("文件下载完成！");
            }
        });
    }
}
