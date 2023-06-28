package lesson03.homework06;

public class Student extends Person{
    private int studyNumber;//学号
    private String schoolTime;//入学时间
    private String major;//专业
    public Student(String name, char sex, int age,int studyNumber,String schoolTime,String major) {
        super(name, sex, age);
        this.studyNumber = studyNumber;
        this.schoolTime = schoolTime;
        this.major = major;
    }

    public int getStudyNumber() {
        return studyNumber;
    }

    public void setStudyNumber(int studyNumber) {
        this.studyNumber = studyNumber;
    }

    public String getSchoolTime() {
        return schoolTime;
    }

    public void setSchoolTime(String schoolTime) {
        this.schoolTime = schoolTime;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    public String toString() {
        return super.toString()+",学号"+getStudyNumber()+",入学时间"+getSchoolTime()+",专业"+getMajor();
    }
}
