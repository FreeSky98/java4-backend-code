package lesson05.homework02;

public class Frog extends Animal implements Swim{
    public Frog(String name, String color, String type) {
        super(name, color, type);
        this.setType("非哺乳类");
    }

    @Override
    public String eat() {
        return "爱吃昆虫";
    }

    @Override
    public String shout() {
        return "呱呱地叫";
    }

    @Override
    public String showInfo() {
        return "那只"+getColor()+"的，名叫"+getName()+"的青蛙正在"+shout()+"\n青蛙是"+getType()+"，"+eat()+"\n"+swim();
    }

    @Override
    public String swim() {
        return "虽然不是鱼，但青蛙也是泳坛高手";
    }
}
