package homework0731;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HW02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("input.txt", true))) {
            while (true) {
                System.out.print("请输入字符(如果输入的是quit,则退出): ");
                input = scanner.nextLine();

                if (input.equalsIgnoreCase("quit")) {
                    break;
                }

                String timestamp = getCurrentTimes();
                String line = timestamp + " " + input;
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }

    /**
     * 获取时间并格式化
     * @return 格式化后的时间now
     */
    private static String getCurrentTimes() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(now);
    }
}
