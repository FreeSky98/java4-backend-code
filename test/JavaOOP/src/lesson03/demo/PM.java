package lesson03.demo;

public class PM extends Employee {
    private int experience;//项目管理经验
    public PM() {
        System.out.println("2.子类PM的无参构造方法");
    }
    public PM(String jobNumber, String name, int age, int experience) {
        super(jobNumber,name,age);
        this.experience = experience;
        System.out.println("2.子类PM的带参构造方法");
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
    @Override
    public void say() {
        System.out.println("大家好，我叫"+getName()
                +"，今年"+this.getAge()
                +"岁，工号是"+this.getJobNumber()
                +"，项目管理经验"
                +this.getExperience()+"年");
    }
}
