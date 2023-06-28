package lesson04.homework04;

public class BaconPizza extends Pizza{
    private int baconGrams;//培根克数
    public BaconPizza(double price, int size,int baconGrams) {
        super(price, size);
        this.setName("培根披萨");
        this.baconGrams = baconGrams;
    }

    public int getBaconGrams() {
        return baconGrams;
    }

    public void setBaconGrams(int baconGrams) {
        this.baconGrams = baconGrams;
    }
    public String showInfo() {
        return super.showInfo()+"培根克数："+getBaconGrams();
    }
}
