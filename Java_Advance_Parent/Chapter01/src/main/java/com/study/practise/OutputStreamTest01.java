package com.study.practise;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamTest01 {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream("D:\\java_projects\\Java_Advance_Parent\\Chapter01\\src\\main\\java\\com\\study\\practise\\哥哥我爱你.txt");

        byte[] bytes = "蔡徐坤你是最棒的啊啊啊啊".getBytes();
        outputStream.write(bytes);

        outputStream.close();
    }
}
