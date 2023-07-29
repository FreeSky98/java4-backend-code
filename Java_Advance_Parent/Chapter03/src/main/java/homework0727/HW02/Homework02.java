package homework0727.HW02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Homework02 {
    //（使用BufferedReader类和FileReader类）完成下面操作。
    //在当前目录下创建一个world cup.txt 的文本文件，其格式如下：
    //1998/法国
    //2002/巴西
    //2006意大利
    //2010/西班牙
    //2014/德国…
    //该文件采用“年份/世界杯冠军”的方式保存每一年世界杯冠军的信息。
    //要求：读入该文件的基础上，让用户输入一个年份，输出该年份对应的世界杯冠军。如果该年没有举办世界杯，则输出“没有举办世界杯”
    public static void main(String[] args) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader bf = null;
        Scanner input = new Scanner(System.in);
        try {
            bf = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\java_projects\\Java_Advance_Parent\\Chapter03\\src\\main\\java\\homework0727\\world cup.txt")));
            String line = "";
            System.out.print("请输入一个年份：");
            String year = input.next();
            int count = 0;
            while ((line = bf.readLine()) != null) {
                if (line.contains(year)) {
                    System.out.println(year+"年世界杯冠军是:"+line.substring(line.indexOf("/") + 1));
                    count++;
                }
            }
            if (count == 0) {
                System.out.println(year+"年没有举办世界杯");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
