package lesson05.demo.interFace4;

/**
 * 手机抽象父类
 */
public abstract class Phone {
    private String brand;
    private String type;

    public Phone() {}

    public Phone(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract void sendInfo();
    public abstract void call();
    public void info() {
        System.out.println("这是一款型号为"+this.type+"的,"+this.brand+"手机");
    }
}
