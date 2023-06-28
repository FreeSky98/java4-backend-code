package lesson03.demo.composite;
/*
 组合也是关联关系的一种特例，它体现的是一种contains-a的关系，这种关系比聚合更强，也称为强聚合。它同样体现整体与部分间的关系，但此时整体与部分是不可分的，整体的生命周期结束也就意味着部分的生命周期结束
 */
public class Person {
    private Brain brain;
    private Heart heart;

    public Person(Brain brain, Heart heart) {
        this.brain = brain;
        this.heart = heart;
    }

    public Brain getBrain() {
        return brain;
    }

    public void setBrain(Brain brain) {
        this.brain = brain;
    }

    public Heart getHeart() {
        return heart;
    }

    public void setHeart(Heart heart) {
        this.heart = heart;
    }
}

class Brain {

}

class Heart {

}


