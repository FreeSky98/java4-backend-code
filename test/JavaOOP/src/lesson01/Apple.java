package lesson01;

public class Apple {
    String name;
    String color;
    String taste;

    public Apple() {
        name = "苹果";
        color = "红色";
        taste = "酸酸的";
    }

    public void getName() {
        System.out.println(this.name);
    }

    public void getColor() {
        System.out.println(this.color);
    }

    public void getTaste() {
        System.out.println(this.taste);
    }
}
class Juicer {
    public String juicing(Apple apple) {
        return "一杯" + apple.color + "的" + apple.name + "汁，味道" + apple.taste;
    }

    public String juicing(Apple apple, Banana banana) {
        return "一杯" + banana.color + "的" + banana.name + apple.name + "汁，味道" + apple.taste + banana.taste;
    }

    public String juicing(Apple a, int num) {
        a.color = "绿色";
        return num + "杯" + a.color + "的" + a.name + "汁，味道" + a.taste;
    }
}

class Banana {
    String name;
    String color;
    String taste;
    public Banana() {
        name = "香蕉";
        color = "黄绿色";
        taste = "甜甜的";
    }

    public void getName() {
        System.out.println(this.name);
    }

    public void getColor() {
        System.out.println(this.color);
    }

    public void getTaste() {
        System.out.println(this.taste);
    }
}


class AppleTest {
    public static void main(String[] args) {
        Juicer juicer = new Juicer();
        Apple apple = new Apple();
        Banana banana = new Banana();
        apple.getName();
        apple.getColor();
        apple.getTaste();
        banana.getName();
        banana.getColor();
        banana.getTaste();
        System.out.println(juicer.juicing(apple, 5));
        System.out.println(juicer.juicing(apple));
        System.out.println(juicer.juicing(apple,banana));
    }
}


