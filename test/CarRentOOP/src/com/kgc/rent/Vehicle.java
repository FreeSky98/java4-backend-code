package com.kgc.rent;

public abstract class Vehicle {
    private String licenseNo;
    private String brand;
    private double dailyPrice;
    /**
     * 全参构造函数
     * @param licenseNo 车牌号
     * @param brand 品牌
     * @param dailyPrice 日租金*/


    public Vehicle(String licenseNo, String brand, double dailyPrice) {
        this.licenseNo = licenseNo;
        this.brand = brand;
        this.dailyPrice = dailyPrice;
    }
    public Vehicle() {

    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }
    /**
     * 计算租金抽象方法
     * @param days 天数
     * @return total 总价格*/
    public abstract double getTotalPrice(int days);
}
