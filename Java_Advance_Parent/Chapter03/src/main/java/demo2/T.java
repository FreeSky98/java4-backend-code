package demo2;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class T {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("占用内存大小：" + "测试adbc12".getBytes(StandardCharsets.UTF_8).length);

        System.out.println("占用内存大小：" + "测试adbc12".getBytes("GB18030").length);

        System.out.println("占用内存大小：" + "测试adbc".getBytes("Unicode").length);
    }
}
