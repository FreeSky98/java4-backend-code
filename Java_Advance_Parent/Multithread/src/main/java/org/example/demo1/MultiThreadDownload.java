package org.example.demo1;

import java.io.File;

public class MultiThreadDownload {
    /*

https://sys-140-0.576360.com/windows/jj/nn/202308a/G_WIN10_X32_V2023.iso


http://down.funfar.top:81/deep/windows_11_professional_x64_2023.iso


     */
    public static void main(String[] args) {
        String fileUrl_Linux = "http://mirrors.sohu.com/centos/8.4.2105/isos/x86_64/CentOS-8.4.2105-x86_64-dvd1.iso";

        String fileUrl_Win10 = "https://sys-140-0.576360.com/windows/jj/nn/202308a/G_WIN10_X32_V2023.iso";

        String fileUrl_Win11 = "http://down.funfar.top:81/deep/windows_11_professional_x64_2023.iso";


        String win10_Path = "D:\\Win10\\win-10.iso";
        String linux_Path = "D:\\Linux\\CentOS-8.4.iso";
        String win11_Path = "D:\\Win11\\win-11.iso";

        File win10File  = new File(win10_Path);
        File win11File  = new File(win11_Path);
        File linuxFile  = new File(linux_Path);
        if(! win10File.getParentFile().exists()) {
            win10File.getParentFile().mkdirs();
            System.out.println("保存win10操作系统iso目录创建成功");
        }

        if(! win11File.getParentFile().exists()) {
            win11File.getParentFile().mkdirs();
            System.out.println("保存win11操作系统iso目录创建成功");
        }

        if(! linuxFile.getParentFile().exists()) {
            linuxFile.getParentFile().mkdirs();
            System.out.println("保存CentOS-8.4操作系统iso目录创建成功");
        }

        //创建下载win10线程对象
        DownloadFile win10Thread = new DownloadFile(fileUrl_Win10,win10File);
        win10Thread.setName("下载Win10线程");

        //创建下载win11线程对象
        DownloadFile win11Thread = new DownloadFile(fileUrl_Win11,win11File);
        win11Thread.setName("下载Win11线程");

        //创建下载linux线程对象
        DownloadFile linuxThread = new DownloadFile(fileUrl_Linux,linuxFile);
        linuxThread.setName("下载Linux线程");


        // 分别启动三个线程
        win10Thread.start();
        win11Thread.start();
        linuxThread.start();

    }
}