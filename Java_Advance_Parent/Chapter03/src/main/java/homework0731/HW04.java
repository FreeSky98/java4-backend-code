package homework0731;

import java.io.File;
import java.util.Scanner;

public class HW04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入文件夹路径:");
        String path = scanner.next();
        File file = new File(path);
        System.out.println("该文件夹大小是："+sum(file)+"Bytes");
    }

    public static long sum(File file) {
        long sum1 = 0;
        if (file.isDirectory()) { //是否是文件夹
            File[] listFiles = file.listFiles();
            for (File listFile : listFiles) {
                //再次判断是否是文件
                if (listFile.isFile()) {
                    sum1 += listFiles.length;//文件字节数进行累计
                } else {
                    sum1 += sum(listFile);//递归累加
                }
            }
        } else {
            System.out.println("请输入文件夹路径！");
        }
        return sum1;
    }
}
