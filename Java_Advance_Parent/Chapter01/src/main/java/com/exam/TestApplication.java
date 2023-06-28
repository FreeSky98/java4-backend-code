package com.exam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TestApplication {

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        do {
            System.out.println("当前中心，合肥科海中心，位于合肥市屯溪路193号，电话629053310");
            System.out.println("请选择操作：1：新生入学登记，2：查看学员信息，3：统计人数，4：毕业离校");
            int choose = input.nextInt();
            switch (choose) {
                case 1 -> {
                    System.out.println("请输入学生姓名：");
                    String name = input.next();
                    System.out.println("请输入学生性别：");
                    char sex = input.next().charAt(0);
                    System.out.println("云豆网账号：");
                    String account = input.next();
                    System.out.println("毕业学校：");
                    String school = input.next();
                    System.out.println("身份证号：");
                    String id = input.next();
                    System.out.println("入学时间：");
                    Date inSchoolTime = sdf.parse(input.next());
                    Student student = new Student(name, account, sex, school, id, inSchoolTime, null);
                    if (studentManager.addStudent(student)) {
                        System.out.println("入学登记完成");
                    } else {
                        System.out.println("该帐号已经存在！");
                    }
                }
                case 2 -> studentManager.showInfo();
                case 3 -> System.out.println("在读人数：" + studentManager.countInSchoolStudents());
                case 4 -> studentManager.outSchool();
            }
        } while (true);
    }

    public static class Student {
        private String name;
        private String account;//账号
        private char sex;
        private String school;//毕业院校
        private String id;//身份证号
        private Date inSchool;//入学时间
        private Date outSchool;//毕业时间

        public Student() {
        }

        public Student(String name, String account, char sex, String school, String id, Date inSchool) {
            this.name = name;
            this.account = account;
            this.sex = sex;
            this.school = school;
            this.id = id;
            this.inSchool = inSchool;
        }

        public Student(String name, String account, char sex, String school, String id, Date inSchool, Date outSchool) {
            this.name = name;
            this.account = account;
            this.sex = sex;
            this.school = school;
            this.id = id;
            this.inSchool = inSchool;
            this.outSchool = outSchool;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public char getSex() {
            return sex;
        }

        public void setSex(char sex) {
            if (sex == '男' || sex == '女') {
                this.sex = sex;
            }
            System.err.println("性别输入有误！性别只能是男或女！");
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Date getInSchool() {
            return inSchool;
        }

        public void setInSchool(Date inSchool) {
            this.inSchool = inSchool;
        }

        public Date getOutSchool() {
            return outSchool;
        }

        public void setOutSchool(Date outSchool) {
            this.outSchool = outSchool;
        }

        public boolean isGraduated() {
            return outSchool != null;
        }


        @Override
        public String toString() {
            if (outSchool == null) {
                return name + "\t" + account + "\t" + sex + "\t" + school + "\t" + inSchool + "\t在读";
            } else {
                return name + "\t" + account + "\t" + sex + "\t" + school + "\t" + inSchool + "\t" + outSchool;
            }
        }
    }

    public static class StudentManager {
        private static final List<Student> students = new ArrayList<>();//学生集合

        static {
            try {
                students.add(new Student("张强", "qiang@qq.com", '男', "合肥二中", "3401034654", new SimpleDateFormat("yyyy-MM-dd").parse("2017-03-09"), new SimpleDateFormat("yyyy-MM-dd").parse("2018-04-02")));
                students.add(new Student("王菲", "feifei@qq.com", '女', "合肥三中", "340109875", new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-09")));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        public StudentManager() {

        }

        public boolean addStudent(Student student) {
            for (Student student1 : students) {
                if (student1.getAccount().equals(student.getAccount())) {
                    return false;
                }
            }
            students.add(student);
            return true;
        }//增加学生功能，判断云豆账号是否重复

        public List<Student> getStudents() {
            return students;
        }

        public List<Student> getInSchoolStudents() {
            List<Student> inSchoolStudents = new ArrayList<>();
            for (Student student : students) {
                if (!student.isGraduated()) {
                    inSchoolStudents.add(student);
                }
            }
            return inSchoolStudents;
        }

        public int countInSchoolStudents() {
            return getInSchoolStudents().size();
        }

        public void showInfo() {
            System.out.println("姓名\t\t\t豆号\t\t性别\t毕业学校\t身份证号\t\t入学时间\t\t\t毕业时间");
            for (Student student : students) {
                System.out.println(student);
            }
        }

        public void outSchool() throws ParseException {
            Scanner input = new Scanner(System.in);
            int count = 0;
            System.out.println("请输入要毕业的学生云豆网账号");
            String account = input.next();
            for (int i = 0; i < StudentManager.students.size(); i++) {
                if (account.equals(StudentManager.students.get(i).getAccount())) {
                    if (StudentManager.students.get(i).getOutSchool() == null) {
                        System.out.println("请输入毕业时间");
                        String date2 = input.next();
                        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
                        Date data = sdf.parse(date2);
                        if ((data.getTime() - StudentManager.students.get(i).getInSchool().getTime()) / (24 * 60 * 60 * 1000) + 1 > 60) {
                            StudentManager.students.get(i).setOutSchool(data);
                            System.out.println("毕业时间更新成功");
                        } else {
                            System.out.println("时间间隔过短！");
                        }
                    } else {
                        System.out.println("此人已经毕业,请核对后重新输入");
                    }
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("没有此人，请核对后重新输入");
            }
        }
    }
}
