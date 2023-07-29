package homework0727.HW03;

import java.io.*;

public class Homework03 {
    public static void main(String[] args) {
        //使用DataInputStream和DataOutputStream实现从控制台中读入一个文件名，判断该文件是否存在。如果该文件存在，则在原文件相同路径下创建一个文件名为“copy_原文件名”的新文件，该文件内容为原文件的拷贝。
        //例如：读入
        //D:/img/photo.jpg
        //则创建一个文件
        //D:/img/copy_photo.jpg
        //新文件内容和原文件内容相同。
        try (
                var reader = new BufferedReader(
                        new InputStreamReader(System.in))
                )
        {
            System.out.println("请输入文件路径名：");
            String filename = reader.readLine();
            //判断文件存在
            File file = new File(filename);
            if (file.exists()) {
                System.out.println("文件存在！");
                String fileName = file.getName();
                String filePath = file.getPath();
                System.out.println("fileName = " + fileName);
                System.out.println("filePath = " + filePath);

                // 构造新文件名
                String newFileName = "copy_" + fileName;
                String newFilePath = filePath.replaceAll(fileName,newFileName);

                File newFile = new File(newFilePath);
                newFile.createNewFile();

                // 使用DataInputStream和DataOutputStream复制文件内容
                DataInputStream dis = new DataInputStream(new FileInputStream(file));
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(newFile));
                byte[] buffer = new byte[1024];
                int length;
                while ((length = dis.read(buffer)) != -1) {
                    dos.write(buffer, 0, length);
                }
                System.out.println("文件拷贝成功！");
                dis.close();
                dos.close();
            } else {
                System.out.println("文件不存在！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
