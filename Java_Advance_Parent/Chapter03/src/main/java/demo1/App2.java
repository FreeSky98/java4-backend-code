package demo1;

import java.io.File;

public class App2 {
    public static void main(String[] args) {
//        File file = new File("D:/test");
//        boolean r = file.mkdir(); // make directory=mkdir 创建新文件夹（只能创建单级）
//        System.out.println("创建一级文件夹 r=" + r);
//        file = new File("D:/test/2023/10/23/img");
//        r = file.mkdirs();// make directory=mkdir 创建新文件夹（只能创建多级）
//        System.out.println("创建多级文件夹 r=" + r);

        File folder = new File("D:\\新建文件夹\\1");
        boolean res = folder.delete();//删除空文件夹和文件
        deleteFolder(folder);
        System.out.println("删除是否成功：" + res);

    }
    public static void deleteFolder(File f) {
        if (f == null) return;
        if (f.isDirectory()) {
            File[] listFiles = f.listFiles();//获取当前路径下所有的子目录和文件列表
            for (File file : listFiles) {
                if (file.isFile()) {
                    file.delete();
                }
                else {
                    deleteFolder(file);
                }
            }
            //如果是空目录，直接删除
            f.delete();
        }
        else {
            f.delete();//删除文件
        }
    }
}
