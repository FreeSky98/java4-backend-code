package demo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ByteStreamDemo {
    //FileInputStream和FileOutputStream
    //1.FileInputStream 文件输入流  ---读取数据
    //2.FileOutStream 文件输出流  ---写入数据
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");//获取当前工程路径
        String filePath = userDir + File.separator + "data" + File.separator + "doc.txt";
        System.out.println(filePath);

        String relativePath = "data\\1.txt";
        File file = new File(relativePath);
        System.out.println("相对路径："+file.getPath());
        System.out.println("绝对路径："+file.getAbsolutePath());
        if (file.getParentFile() != null && !file.getParentFile().exists()){
            file.getParentFile().mkdirs();//创建文件夹
            System.out.println("创建新目录成功！");
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("新的文本文件创建成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            String str = new String("Hello,Java!");
            fos.write(str.getBytes(StandardCharsets.UTF_8));
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
