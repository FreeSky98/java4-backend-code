package demo2;

import java.io.*;

public class TemplateFile {
    //定义模板文件路径
    public static final String TMPL_FILE_PATH = "data/data.tmpl";
    public static StringBuffer readFromFile(File srcFile) {
        StringBuffer sb = new StringBuffer(16);
        try (var reader = new BufferedReader(new FileReader(srcFile),8192))//读取器对象)
        {
            String line = "";
            //循环每次读取一行，将读取到每一行数据追加到字符串缓冲区中
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\r\n");
            }
            return sb;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 处理数据（占位符替换真实数据）
     * @param buffer 字符串数据
     * @return 替换后的字符串数据
     */
    public static String processData(StringBuffer buffer) {
        return buffer.toString()
                .replace("{name}","跳跳")
                .replace("{type}","吉娃娃")
                .replace("{master}","佺");
    }

    /**
     * 将处理后的数据写入到磁盘文件
     * @param content 处理后的数据
     * @param targetFile 磁盘文件
     * @return 结果
     */
    public static boolean writeToFile(String content,File targetFile) {
        try(
                //写入器
                var writer = new BufferedWriter(new FileWriter(targetFile))
                ) {
            writer.write(content);
            writer.flush();//强制刷新缓冲区
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        StringBuffer buffer = readFromFile(new File(TMPL_FILE_PATH));
        String content = null;
        if (buffer != null) {
            content = processData(buffer);
        }
        boolean result = writeToFile(content,new File("data/pet.txt"));
        System.out.println(result ? "写入成功" : "写入出错啦");
    }
}
