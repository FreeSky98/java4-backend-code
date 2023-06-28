package lesson06.homework789;

import java.util.Objects;
import java.util.Scanner;

public class Person {
    private String gender;
    private int age;

    public Person(String gender,int age) {
        this.gender = gender;
    }

    public Person() {

    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception{
        if (age > 1 && age < 100) {
            this.age = age;
        }
        else {
            throw new Exception("年龄必须在1到100之间！");
        }
    }

    public void setGender(String gender) throws GenderException{
        if (Objects.equals(gender, "男") || Objects.equals(gender, "女"))  {
            this.gender = gender;
        }
        else {
            throw new GenderException("性别必须是”男“或者”女“！");
        }
    }
}

class GenderException extends Exception{

    public GenderException(String message) {
        super(message);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
class Test {
    public static void main(String[] args) {
        Person person = new Person();
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("请输入此人的性别：");
            String gender = input.next();
            person.setGender(gender);
            System.out.println(person.getGender());
        } catch (GenderException e) {
            e.printStackTrace();
        }

//        try {
//            System.out.print("请输入此人的年龄：");
//            int age = input.nextInt();
//            person.setAge(age);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
