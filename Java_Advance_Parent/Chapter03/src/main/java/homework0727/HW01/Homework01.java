package homework0727.HW01;

import java.io.*;

public class Homework01 {
    //（FileInputStream 和FileOutputStream）利用FileInputStream 和FileOutputStream，完成
    //下面的要求：
    //1） 用FileOutputStream 在当前项目doc目录下创建一个文件“test.txt”，并向文件写入“HelloWorld”，
    // 如果文件已存在，则在原有文件内容后面追加内容。
    //2） 用FileInputStream 读取test.txt 文件，并在控制台上打印出test.txt 中的内容。
    //3） 要求用try-catch-finally 处理异常，并且关闭流应放在finally 块中。
    public static void main(String[] args) {
        File file = new File("doc/test.txt");
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
            System.out.println("创建新目录成功！");
        } else {
            System.out.println("目录已存在或父类路径为空！");
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("文件test.txt创建成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String filePath = "doc/test.txt";
        String content = "Hello World";

        // 写入文件
        try {
            FileOutputStream fos = new FileOutputStream(filePath, true);
            fos.write(content.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 读取文件
        try {
            FileInputStream fis = new FileInputStream(filePath);
            int ch;
            StringBuilder sb = new StringBuilder();

            while ((ch = fis.read()) != -1) {
                sb.append((char) ch);
            }
            System.out.println(sb);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
