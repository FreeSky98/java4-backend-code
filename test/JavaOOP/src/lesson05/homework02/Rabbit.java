package lesson05.homework02;

public class Rabbit extends Animal{
    public Rabbit(String name, String color, String type) {
        super(name, color, type);
        this.setType("哺乳类");
    }

    @Override
    public String eat() {
        return "爱吃胡萝卜";
    }

    @Override
    public String shout() {
        return "叽叽地叫";
    }

    @Override
    public String showInfo() {
        return "那只"+getColor()+"的，名叫"+getName()+"的兔子正在"+shout()+"\n兔子是"+getType()+"，"+eat();
    }
}
