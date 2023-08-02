package org.example.v5;

/**
 * 计算机类
 */
public class Computer {
    private String brand;//品牌
    private String type;//型号
    private double price;//价格

    public String showInfo() {
        return "计算机信息如下：\n"+"品牌："+brand+",型号："+type+",价格："+price;
    }

    public Computer() {
    }

    public Computer(String brand, String type, double price) {
        this.brand = brand;
        this.type = type;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
