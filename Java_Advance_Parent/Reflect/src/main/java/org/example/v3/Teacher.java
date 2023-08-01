package org.example.v3;

/**
 * 老师子类
 */
public class Teacher extends People {

    private String post;

    public Teacher() {
    }

    public Teacher(String name, int age,String post) {
        super(name, age);
        this.post = post;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    /**
     独有的行为，发布问题
     */
    public void writeQuestion(){
        System.out.println(getName() + "学的怎么样?");
    }
}
