package lesson03.demo;

public class Employee {
    private String jobNumber; //工号
    private String name;
    private int age;
    public Employee() {
        System.out.println("1.父类无参构造方法");
    }

    public Employee(String jobNumber, String name, int age) {
        this.jobNumber = jobNumber;
        this.name = name;
        this.age = age;
        System.out.println("1.父类带参构造方法");
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void say() {
        System.out.println("大家好，我叫"+this.getName()+"，今年"+this.getAge()+"岁，工号是"+this.getJobNumber());
    }
}
