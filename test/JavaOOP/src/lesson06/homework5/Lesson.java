package lesson06.homework5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lesson {
    private String lessonName;//课程名

    public Lesson(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }
}

class Test {
    public static void main(String[] args) {
        Lesson[] lessons = new Lesson[3];
        Scanner input = new Scanner(System.in);
        lessons[0] = new Lesson("C#编程");
        lessons[1] = new Lesson("Java编程");
        lessons[2] = new Lesson("Python编程");

        try {
            System.out.print("请输入课程代号（1~3之间的数字）：");
            int choose = input.nextInt();
            System.out.println(lessons[choose-1].getLessonName());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("请输入有效数字（1~3）");
            //e.printStackTrace();
        } catch (InputMismatchException e) {
            System.err.println("请输入有效整数（1~3），不可以是字母、英文、小数或下划线");
            //e.printStackTrace();
        } catch (Exception e) {
            System.err.println("未知错误，错误信息为");
            e.printStackTrace();
        }
        finally {
            System.out.println("欢迎提出建议！");
        }

    }
}
