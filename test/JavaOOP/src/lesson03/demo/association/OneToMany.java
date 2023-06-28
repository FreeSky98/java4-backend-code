package lesson03.demo.association;

/**
 * 班级类
 */
class Class {
    // 一个班级包含多名学生
    private Student[] students;

    public Class() {}

    public Class(int capacity) {
        students = new Student[capacity];
    }
}

/**
 * 学生类
 */
class Student {
    /**
     * 所属班级
     */
    private Class clazz;

    public Student() {
        clazz = new Class();
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}

public class OneToMany {
}
