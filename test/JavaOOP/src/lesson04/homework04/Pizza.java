package lesson04.homework04;

public class Pizza {
    private String name;//名称
    private double price;//价格
    private int size;//尺寸大小

    public Pizza(double price, int size) {
        this.price = price;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public String showInfo() {
        return "名称："+getName()+"\n价格："+getPrice()+"元\n大小："+getSize()+"寸\n";
    }
}
