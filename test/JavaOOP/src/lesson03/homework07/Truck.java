package lesson03.homework07;

public class Truck extends Car{
    private int payLoad;//载重量

    public Truck(int wheels, int weight, int loader,int payLoad) {
        super(wheels, weight, loader);
        this.payLoad = payLoad;
    }

    public int getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(int payLoad) {
        this.payLoad = payLoad;
    }
    public String toString() {
        return super.toString()+",载重量："+getPayLoad()+"吨";
    }
}
