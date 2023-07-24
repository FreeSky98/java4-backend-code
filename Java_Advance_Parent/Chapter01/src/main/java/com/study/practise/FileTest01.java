package com.study.practise;

import java.io.File;
import java.io.IOException;

public class FileTest01 {
    public static void main(String[] args) throws IOException {
        searchFile(new File("D:\\GameDownload\\WeGame"),"wegame.exe");
    }

    /**
     * 方法：搜索文件并打开
     * @param dir 文件所在磁盘目录
     * @param fileName 文件名
     */

    public static void searchFile(File dir, String fileName) throws IOException {
        if (dir == null || !dir.exists() || dir.isFile()) {
            return;
        }
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().contains(fileName)) {
                        System.out.println("该文件路径："+file.getAbsolutePath());
//                        Runtime runtime = Runtime.getRuntime();
//                        runtime.exec(file.getAbsolutePath());
                    }
                    else {
                        searchFile(file,fileName);
                    }
                }
            }
        }
    }
}
