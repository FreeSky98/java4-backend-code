package lesson01;

import java.util.Arrays;

public class StudentDemo01 {
    int score;
    String name;
    public StudentDemo01(int score, String name) {
        this.score = score;
        this.name = name;
    }

    @Override
    public String toString() {
        //return getClass().getName() + "@" + Integer.toHexString(hashCode());
        //System.out.println("重写Object类toString()");
        return "学生姓名：" + this.name + "，学生成绩：" + this.score;
    }
}

class Test {
    public static void rise(StudentDemo01[] formal_parameter_array) {
        if(formal_parameter_array == null || formal_parameter_array.length == 0) return;
        for (int i = 0; i < formal_parameter_array.length; i++) {
            if(formal_parameter_array[i].score < 60) {
                formal_parameter_array[i].score += 2;
            }
        }
    }
    public static void main(String[] args) {
        StudentDemo01 s1 = new StudentDemo01(56,"张三");
        StudentDemo01 s2 = new StudentDemo01(58,"李四");
        StudentDemo01 s3 = new StudentDemo01(65,"王五");
        StudentDemo01 s4 = new StudentDemo01(86,"赵六");
        StudentDemo01[] studentDemo01s = {
                s1,s2,s3,s4
        };
        System.out.println("提分前：");
        System.out.println(Arrays.toString(studentDemo01s));

        rise(studentDemo01s);
        System.out.println("提分后：");
        System.out.println(Arrays.toString(studentDemo01s));
    }
}
