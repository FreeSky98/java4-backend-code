package ReviewOOP;

//员工抽象类
public abstract class Staff {
    private String id; // 工号
    private String name; //姓名
    private int age; //年龄
    private String sex; //性别
    private double salary;//基本工资
    //工作（抽象方法）
    public abstract void work(String content);
    public abstract double income();

    //无参构造方法
    public Staff() {
    }
    //带参构造方法
    public Staff(String id, String name, int age, String sex, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
