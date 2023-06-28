package lesson03.homework04;

public class PM extends Employee{
    private String yearsOfExperience;

    public PM(String name, String address, String telephone, String email, String office, double salary, String hireDate,String yearsOfExperience) {
        super(name, address, telephone, email, office, salary, hireDate);
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    public void introduce() {
        System.out.println("我的名字是"+getName()+",手机号"+getTelephone()+",管理经验已经有"+getYearsOfExperience()+"年了。");
    }
}
