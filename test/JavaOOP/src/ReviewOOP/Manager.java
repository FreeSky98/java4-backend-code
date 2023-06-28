package ReviewOOP;

//经理子类
public class Manager extends Staff {
    //项目津贴
    private double allowance;

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public Manager() {
    }

    public Manager(String id, String name, int age, String sex, double salary,double allowance) {
        super(id, name, age, sex, salary);

        //扩展属性赋值
        this.setAllowance(allowance);
    }

    @Override  //方法重写
    public void work(String content) {
        System.out.println("工号:" + super.getId()
                +",基本工资:"+ super.getSalary()
                +",项目奖金：" + this.getAllowance()
                + ",工作内容：" + content);
    }

    @Override
    public double income() {
        return 0;
    }

    //扩展实例方法 开项目例会
    public void meeting(String title,
                        String content,
                        String place,
                        String time) {
        System.out.println("会议标题：" + title);
        System.out.println("会议内容：" + content);
        System.out.println("会议地点：" + place);
        System.out.println("会议时间：" + time);
    }
}
