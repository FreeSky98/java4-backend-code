package lesson03.homework06;

public class Teacher extends Person{
    private int jobNumber;
    private double salary;
    private String level;//职称
    private String office;//部门
    public Teacher(String name, char sex, int age,int jobNumber,double salary,String level,String office) {
        super(name, sex, age);
        this.jobNumber = jobNumber;
        this.salary = salary;
        this.level = level;
        this.office = office;
    }

    public int getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(int jobNumber) {
        this.jobNumber = jobNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
    public String toString() {
        return super.toString()+",工号"+getJobNumber()+",月薪"+getSalary()+"元,职称"+getLevel()+",部门"+getOffice();
    }
}
