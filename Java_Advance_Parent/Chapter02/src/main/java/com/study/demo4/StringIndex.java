package com.study.demo4;

import java.util.UUID;

public class StringIndex {
    public static void main(String[] args) {
        //文件上传涉及字符串查询相关方法
        String filename = UUID.randomUUID().toString().replaceAll("-","").concat(".jpg");
        String filePath = "D:\\GameDownload\\WeGame" + filename;
        System.out.println("filename = " + filename);

        int lastDotIndex = filePath.lastIndexOf("."); //从后往前查找“.”找到返回下标
        int lastSlashIndex = filePath.lastIndexOf("\\");
        System.out.println("lastDotIndex = " + lastDotIndex);
        System.out.println("lastSlashIndex = " + lastSlashIndex);

        String originalFileName = filePath.substring(lastSlashIndex+1,lastDotIndex);
        String fileExtension = filePath.substring(lastDotIndex);//提取从lastDotIndex位置索引开始的字符串部分

        System.out.println("文件后缀名：" + fileExtension);
        System.out.println("文件名称：" + originalFileName);
    }
}
