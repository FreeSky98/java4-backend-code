package com.javaboy.spider;

import cn.hutool.http.HttpUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class M3U8Parser {
    //思路：
    //1.分析m3u8文件，将m3u8文件中存储的*.ts文件名解析出来
    public static List<String> getTsListByM3U8(String m3u8Url) throws Exception {
        List<String> tsList = new ArrayList<>();
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36");
        paramMap.put("Origin", "https://basic.smartedu.cn");
        paramMap.put("Referer", "https://basic.smartedu.cn/");
        paramMap.put("X-Nd-Auth","MAC id=\"7F938B205F876FC3A30551F3A49313835AF703E1D1C26346BF2DFD216663977F851E9A69EAAEB62D69D8434E07BA479C76A71B94078704AC\",nonce=\"1693294992421:BI6EH1KX\",mac=\"57eoWAgVkbetgGaYRmnqO/i1zvg+O5e5NFYtK9eH+SI=\"");
        URL url = new URL(m3u8Url);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        if(! paramMap.isEmpty()) {
            paramMap.forEach((key,value)-> {
                con.setRequestProperty(key,value);
            });
        }
        con.setRequestMethod("GET");
        con.setDoInput(true);
        con.setDoOutput(true);
        int statusCode = con.getResponseCode();
        System.out.println("服务器响应的状态码：" + statusCode);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        con.getInputStream(), StandardCharsets.UTF_8));
        // 保存读取的数据字符串
        StringBuilder sb = new StringBuilder();
        String line = null;
        // 循环读取数据
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\r\n");
        }
        //System.out.println("从服务器中读取的数据内容是: ");
        //System.out.println(sb);
        br.close();
        con.disconnect();
        Pattern pattern = Pattern.compile("(?<ts>[a-zA-Z0-9-\\.]+\\.ts)");
        Matcher matcher = pattern.matcher(sb.toString());
        while (matcher.find()) {
            String tsFileName = matcher.group("ts");
            tsList.add(tsFileName);
        }
        return tsList;
    }
    //2.将*.ts二进制文件下载到本地(ts\1.ts) 下载此ts文件一定要注意下载顺序
    public static void download(String tsUrl,File destFile) throws Exception{
        URL url = new URL(tsUrl);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();

        //设置请求头
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36");

        paramMap.put("Referer", "https://basic.smartedu.cn/");
        paramMap.put("Origin", "https://basic.smartedu.cn");
        paramMap.put("Origin", "MAC id=\"7F938B205F876FC3A30551F3A49313835AF703E1D1C26346BF2DFD216663977F851E9A69EAAEB62D69D8434E07BA479C76A71B94078704AC\",nonce=\"1693295049387:GF3VG8R8\",mac=\"Wy65EMHYA6hgfwfCf2Gj1SAzsw5XOms8Qn7MjJPIUU0=\"");






        if(! paramMap.isEmpty()) {
            paramMap.forEach((key,value)-> {
                con.setRequestProperty(key,value);
            });
        }
        con.setRequestMethod("GET");
        con.setDoInput(true);
        con.setDoOutput(true);
        int statusCode = con.getResponseCode();
        System.out.println("服务器响应的状态码：" + statusCode);
        InputStream is = con.getInputStream();
        FileOutputStream os = new FileOutputStream(destFile);
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer,0,len);
            os.flush();
        }
        System.out.println("下载ts完成！");
        os.close();
        is.close();
        con.disconnect();
    }
    //3.将下载所有的*.ts二进制文件合并(ffmpeg工具)成一个完成的视频(*.mp4)
    public static void mergeVideo(String tsDir,String video_name) throws IOException {


    }
    //4.测试下载教学视频

    public static void main(String[] args) throws Exception {
        String workDir = System.getProperty("user.dir");
        /*List<String> tsFileList= getTsListByM3U8("https://r2-ndr-private.ykt.cbern.com.cn/edu_product/65/video/17b0bf2a547a11eb96b8fa20200c3759/ae33d1456cb812887e7eb881c1f0f319.1920.1080.false/ae33d1456cb812887e7eb881c1f0f319.1920.1080.m3u8");
        //System.out.println(tsFileList.size());
        for (int i = 0;i < tsFileList.size();i++) {
            //System.out.println(tsFile);
            String tsUrl = "https://r2-ndr-private.ykt.cbern.com.cn/edu_product/65/video/17b0bf2a547a11eb96b8fa20200c3759/ae33d1456cb812887e7eb881c1f0f319.1920.1080.false/" + tsFileList.get(i);
            Thread.sleep(100);
            download(tsUrl,new File(workDir,"ts/" + i + ".ts"));
        }*/


        mergeVideo(null,null);



    }
}
