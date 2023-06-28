package lesson03.homework02;

public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void eat() {
        System.out.println("吃东西");
    }
    public void sleep() {
        System.out.println("睡觉");
    }
}
