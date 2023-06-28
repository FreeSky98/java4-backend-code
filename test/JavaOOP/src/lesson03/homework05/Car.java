package lesson03.homework05;

public class Car {
    private String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void drive() {
        System.out.println("车在行驶");
    }
    public void showInfo() {
        System.out.print("品牌："+getBrand());
    }
}
