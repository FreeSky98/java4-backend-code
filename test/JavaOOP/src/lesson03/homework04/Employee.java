package lesson03.homework04;

public class Employee extends Person{
    private String office;
    private double salary;
    private String hireDate;

    public Employee(String name, String address, String telephone, String email,String office,double salary,String hireDate) {
        super(name, address, telephone, email);
        this.office = office;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
}
