package homework0731;

import java.io.*;

public class HW05 {
    public static void main(String[] args) {
        try {
            insert("d:/out.txt", 5, "插入的内容");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void insert(String fileName, long pos, String content) throws IOException {
        //创建临时空文件
        File tempFile = File.createTempFile("temp", null);
        //在虚拟机终止时，请求删除此抽象路径名表示的文件或目录
        tempFile.deleteOnExit();
        FileOutputStream fos = new FileOutputStream(tempFile);
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

        raf.seek(pos);

        byte[] buffer = new byte[4];
        int num = 0;
        while ((num = raf.read(buffer)) != -1) {
            fos.write(buffer, 0, num);
        }

        raf.seek(pos);
        raf.write(content.getBytes());
        FileInputStream fis = new FileInputStream(tempFile);

        while ((num = fis.read(buffer)) != -1) {
            raf.write(buffer, 0, num);
        }
    }
}

