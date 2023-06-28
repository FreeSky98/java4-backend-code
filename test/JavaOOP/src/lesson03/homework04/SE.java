package lesson03.homework04;

public class SE extends Employee{
    private String hobby;
    private String level;

    public SE(String name, String address, String telephone, String email, String office, double salary, String hireDate,String hobby,String level) {
        super(name, address, telephone, email, office, salary, hireDate);
        this.hobby = hobby;
        this.level = level;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    public void introduce() {
        System.out.println("我的名字是"+getName()+",手机号"+getTelephone()+",爱好"+getHobby()+",级别是"+getLevel());
    }
}
