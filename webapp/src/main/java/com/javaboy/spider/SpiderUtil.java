package com.javaboy.spider;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class SpiderUtil {
    public static void download(String pdfUrl,
                                Map<String,String> paramMap,File destFile) throws Exception{
        URL url = new URL(pdfUrl);
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
        InputStream is = con.getInputStream();
        FileOutputStream os = new FileOutputStream(destFile);
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer,0,len);
            os.flush();
        }
        System.out.println("下载完成！");
        os.close();
        is.close();
        con.disconnect();
    }

    public static void main(String[] args) throws Exception {
        String pdfUrl = "https://r2-ndr-private.ykt.cbern.com.cn/edu_product/esp/assets_document/2ce8f153-7bff-4c97-b6db-9aac414fea19.pkg/pdf.pdf";
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36");
        paramMap.put("Origin", "https://basic.smartedu.cn");
        paramMap.put("Referer", "https://basic.smartedu.cn/");
        paramMap.put("X-Nd-Auth", "MAC id=\"7F938B205F876FC3A30551F3A49313835AF703E1D1C26346BF2DFD216663977F851E9A69EAAEB62D69D8434E07BA479C76A71B94078704AC\",nonce=\"1693291905517:9LWPVIAN\",mac=\"hZINnxHPgkHyXrgXEljpj nok02UbYzzqiCZgVoEXUY=\"");



        download(pdfUrl,paramMap,new File("语文一年级上册.pdf"));
    }

}
