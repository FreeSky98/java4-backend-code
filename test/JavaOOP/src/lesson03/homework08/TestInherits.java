package lesson03.homework08;

public class TestInherits {
    public static void main(String[] args) {
        Child c = new Child();
    }
}
class Grandparent {
    public Grandparent() {
        System.out.println("GrandParent Created.");
    }

    public Grandparent(String string) {
        System.out.println("GrandParent Created.String:" + string);
    }
}

class Parent extends Grandparent {
    public Parent() {
        super("Hello.Grandparent.");
        System.out.println("Parent Created");
        // super("Hello.Grandparent.");
    }
}

class Child extends Parent {
    public Child() {
        System.out.println("Child Created");
    }

}
