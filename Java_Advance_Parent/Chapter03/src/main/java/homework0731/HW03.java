package homework0731;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class HW03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入文件名:");
        String filePath = scanner.next();
        if (!filePath.contains(".")) {
            System.out.println("输入的文件格式有误");
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] magicNumber = new byte[4]; // 读取前4个字节的魔术数
            fis.read(magicNumber);

            if (isJPEG(magicNumber)) {
                System.out.println("文件格式为JPEG");
            } else if (isPNG(magicNumber)) {
                System.out.println("文件格式为PNG");
            } else if (isGIF(magicNumber)) {
                System.out.println("文件格式为GIF");
            } else {
                System.out.println("文件格式未知");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isJPEG(byte[] magicNumber) {
        return (magicNumber[0] == (byte) 0xFF &&
                magicNumber[1] == (byte) 0xD8 &&
                magicNumber[2] == (byte) 0xFF &&
                magicNumber[3] == (byte) 0xE0);
    }

    private static boolean isPNG(byte[] magicNumber) {
        return (magicNumber[0] == (byte) 0x89 &&
                magicNumber[1] == (byte) 0x50 &&
                magicNumber[2] == (byte) 0x4E &&
                magicNumber[3] == (byte) 0x47);
    }

    private static boolean isGIF(byte[] magicNumber) {
        return (magicNumber[0] == (byte) 0x47 &&
                magicNumber[1] == (byte) 0x49 &&
                magicNumber[2] == (byte) 0x46 &&
                magicNumber[3] == (byte) 0x38);
    }
}
