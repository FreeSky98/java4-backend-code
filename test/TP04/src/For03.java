import java.util.Scanner;

public class For03 {
    static Scanner input = new Scanner(System.in);
    int classNum;
    double sum;
    double avg;
    int people;

    void setClassNum() {
        System.out.print("请输入班级数量：");
        this.classNum = input.nextInt();
    }

    void setPeople() {
        this.people = input.nextInt();
    }

    double getSumAndAvg() {
        int a = 0;
        for (int i = 0; i < classNum; i++) {
            System.out.println("请输入第"+ (i + 1) +"个班级的人数");
            setPeople();
            int[] scores = new int[people];
            for (int j = 0; j < scores.length; j++) {
               System.out.println("第" + (j + 1) + "个学生的成绩");
                scores[j] = input.nextInt();
                this.sum += scores[j];
            }
            this.avg = this.sum / scores.length;
            a += avg;
            System.out.println("第" + (i + 1) + "个班级参赛学员的平均分是：" + this.avg + "\n");
        }
        return a;
    }

    public static void main(String[] args) {
        For03 for03 = new For03();
        for03.setClassNum();
        System.out.println("for03.getSumAndAvg() = " + for03.getSumAndAvg());
//        for (int i = 0; i < classNum; i++) {
//            sum = 0.0;
//            System.out.println("请输入第"+ (i + 1) +"个班级的人数");
//            int people = input.nextInt();
//            int[] scores = new int[people];
//            for (int j = 0; j < scores.length; j++) {
//                System.out.println("第" + (j + 1) + "个学生的成绩");
//                scores[j] = input.nextInt();
//                sum += scores[j];
//            }
//            avg = sum / scores.length;
//            System.out.println("第" + (i + 1) + "个班级参赛学员的平均分是：" + avg + "\n");
//        }
    }
}
