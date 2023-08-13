package org.net5;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import java.io.File;

/**
 * 下载视频线程类
 * @author lds
 */
public class DownloadVideoThread implements Runnable {

    private String url;
    private String path;

    public DownloadVideoThread(String url, String path) {
        this.url = url;
        this.path = path;
    }

    @Override
    public void run() {
        File folderFile = new File(this.path);
        if (! folderFile.exists()) {
            folderFile.mkdirs(); //创建保存视频的文件夹(目录)
        }
        String jsonData =
                Crawler.getDataByURL(this.url, "UTF-8");

        // 解析JSON数据   阿里开源的JSON解析框架
        JSONObject jsonObject = JSON.parseObject(jsonData);
        JSONArray jsonArray = null;
        if (jsonObject != null) {
            jsonArray = jsonObject.getJSONArray("data");
        }
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                String videoTitle = Crawler.filterTitle(jsonObject2.getString("title"));
                String videoUrl = jsonObject2.getString("playUrl");
                File destFile = new File(folderFile,videoTitle+".mp4");
                Crawler.saveVideo(destFile,videoUrl);
            }
        }
        // 模拟网络延时
        try {
            Thread.sleep(300L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
