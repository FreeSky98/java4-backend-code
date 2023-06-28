import java.util.Scanner;

import java.text.ChoiceFormat;
import java.text.NumberFormat;
public class NestedForLoop03 {
    public static String toFraction(double value) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        return nf.format(value);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("班级数量：");
        int classNum = input.nextInt();
        System.out.println("班级总人数：");
        int students = input.nextInt();
        int count = 0;

        label:
        for (int i = 0; i < classNum; i++) {
            System.out.println("请输入第"+ (i+1) + "个班的学生成绩信息");
            for (int j = 0; j < students; j++) {
                System.out.println("\t\t请输入第" + (j + 1) +"位学生的成绩:");
                int score = input.nextInt();
                if (score < 0 || score > 150) {
                    System.out.println("输入非法，退出主程序");
                    break label;
                }
                if (score < 80) {
                    continue;
                }
                count++;
            }

            double ratio = (double) count / students;
            System.out.println("第" + (i + 1) + "班80分以上的学生人数是：" + count);
            System.out.println("第" + (i + 1) + "班80分以上的学生所占的比例为：" + (toFraction(ratio*100)) + "%");

            count = 0;
        }
    }
}
