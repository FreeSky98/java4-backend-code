package lesson03.homework05;

public class Benchi extends Car{
    private double price;
    private String type;
    public Benchi(String brand,double price,String type) {
        super(brand);
        this.price = price;
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void drive() {
        System.out.println(getBrand()+"车在变速行驶");
    }
    public void showInfo() {
        super.showInfo();
        System.out.println("，价格："+getPrice()+"万元，型号："+getType());
    }
}
