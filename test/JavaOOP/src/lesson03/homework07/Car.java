package lesson03.homework07;

public class Car extends Vehicle{
    private int loader;//载人数

    public Car(int wheels, int weight,int loader) {
        super(wheels, weight);
        this.loader = loader;
    }

    public int getLoader() {
        return loader;
    }

    public void setLoader(int loader) {
        this.loader = loader;
    }
    public String toString() {
        return super.toString()+",载人数："+getLoader()+"人";
    }
}
