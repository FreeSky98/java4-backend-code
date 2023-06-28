package lesson03.demo;


public class SE extends Employee {
    private int popularity;//人气程度
    public SE() {
        System.out.println("2.子类SE无参构造方法");
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public SE(String jobNumber, String name, int age, int popularity) {
        super(jobNumber,name,age);
        this.setPopularity(popularity);
        System.out.println("2.子类SE带参构造方法");
    }
    @Override
    public void say() {
        System.out.println("大家好，我叫"+this.getName()
                +"，今年"+this.getAge()
                +"岁，工号是"+this.getJobNumber()
                +"，在公司的人气程度"
                +this.getPopularity()+"%");
    }
}
