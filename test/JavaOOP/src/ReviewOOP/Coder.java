package ReviewOOP;

//程序员子类
public class Coder extends Staff {
    public Coder() {
    }
    public Coder(String id, String name, int age, String sex, double salary,int popularity) {
        super(id, name, age, sex, salary);
        this.setPopularity(popularity);
    }
    //人气值
    private int popularity;

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    @Override
    public void work(String content) {
        System.out.println("工号:" + super.getId()
                +",基本工资:"+ super.getSalary()
                +",人气值高达：" + this.getPopularity()
                + ",工作内容：" + content);
    }

    @Override
    public double income() {
        return 0;
    }

    //晋升方法（扩展方法）
    public void promote() {
        if(this.popularity >= 100) {
            this.setSalary(this.getSalary() + 300);
            System.out.println("达到晋升条件，升职加薪");
        }
        else {
            System.out.println("你未达到升职加薪条件，继续努力！");
        }
    }

}
