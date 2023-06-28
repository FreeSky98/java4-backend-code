package com.homework03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Employee {
    private int empNum;//工号
    private String name;
    private int age;
    private double salary;//工资

    public Employee() {
    }

    public Employee(int empNum, String name, int age, double salary) {
        this.empNum = empNum;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getEmpNum() {
        return empNum;
    }

    public void setEmpNum(int empNum) {
        this.empNum = empNum;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
            return this.empNum == ((Employee) obj).empNum && Objects.equals(this.name, ((Employee) obj).name);
        }
        return false;
    }

    @Override
    public String toString() {
        return "员工号："+getEmpNum()+",员工姓名："+getName()+",员工年龄："+getAge()+",员工工资："+getSalary();
    }

    public void work() {
        System.out.println("工号："+getEmpNum()+",姓名："+getName()+"的员工正在搬砖中");
    }
}

class EmployeeManager {
    public final static ArrayList<Employee> employeeArrayList = new ArrayList<>();

    static {
        employeeArrayList.add(new Employee(1,"zhangsan",18,3000));
        employeeArrayList.add(new Employee(2,"lisi",25,3500));
        employeeArrayList.add(new Employee(3,"wangwu",22,3200));
    }
}

class Test {
    public static void main(String[] args) {
        EmployeeManager.employeeArrayList.add(1,new Employee(4,"zhaoliu",24,3300));
        EmployeeManager.employeeArrayList.remove(3);
        for (Employee employee : EmployeeManager.employeeArrayList) {
            System.out.println(employee);
        }
        Iterator<Employee> it = EmployeeManager.employeeArrayList.iterator();
        while (it.hasNext()) {
            Employee next =  it.next();
            next.work();
        }
    }
}
