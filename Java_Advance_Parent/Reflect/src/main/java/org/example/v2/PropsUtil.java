package org.example.v2;
import java.io.FileReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsUtil {
    //Properties类读取*.properties属性文件，根据Key获取映射的Value
    private static Properties props = null;

    static {
        // 创建属性类对象
        props = new Properties();
        InputStream inputStream = null;
        try {
            // 加载外部*.properties文件到内存中
            //D:\java82_jybc\Java_Reflect\src\main\resources\goods.properties

            // 通过ClassLoader读取resources下的文件
            inputStream = PropsUtil.class.getClassLoader().getResourceAsStream("goods.properties");
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getValueByKey(String keyName) {
        return props.getProperty(keyName);
    }


    public static void main(String[] args) {
        System.out.println(PropsUtil.getValueByKey("k1"));
        System.out.println(PropsUtil.getValueByKey("k2"));
        System.out.println(PropsUtil.getValueByKey("k3"));
    }
}