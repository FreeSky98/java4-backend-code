package practise;

import java.io.File;

public class FilePractise {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\朝日日语王先生\\Desktop\\日语练习题合集\\高考日语题库\\福建2022高考日语质检\\8.jpg");
        System.out.println("名称："+file.getName());
        System.out.println("相对路径："+file.getPath());
        System.out.println("绝对路径："+file.getAbsolutePath());
        System.out.println("文件大小："+file.length()+"字节");
    }
}
