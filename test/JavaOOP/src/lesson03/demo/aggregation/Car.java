package lesson03.demo.aggregation;

/**
 *  聚合是关联关系的一种特例，它体现的是整体与部分的关系，即has-a的关系。此时整体与部分之间是可分离的，它们可以具有各自的生命周期，部分可以属于多个整体对象，也可以为多个整体对象共享。比如计算机与CPU、公司与员工的关系等
 */
class Engine {

}

class Tire {

}
//聚合是关联关系的一种特例, 体现类与类之间整体与部分的关系.类和类之间的具有各自的生命周期, 整体和部分之间是可分离的.
public class Car {
    private Engine engine;
    private Tire[] tires;

    public Car(Engine engine, Tire[] tires) {
        this.engine = engine;
        this.tires = tires;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Tire[] getTires() {
        return tires;
    }

    public void setTires(Tire[] tires) {
        this.tires = tires;
    }
}
