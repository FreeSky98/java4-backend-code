package com.kgc.rent;

public class Truck extends Vehicle{
    private int load;

    public Truck(String licenseNo, String brand, double dailyPrice, int load) {
        super(licenseNo, brand, dailyPrice);
        this.load = load;
    }

    public Truck() {

    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    @Override
    public double getTotalPrice(int days) {
        /*
         货车费用计算方法
         30天以内(含30)按日租金计算
         30天以上超出部分:每天，每吨（载重量）增加日租金10%
         */
        double totalPrice;
        double basicPrice = days * this.getDailyPrice();
        if (days <= 30) {
            totalPrice = basicPrice;
        } else {
            totalPrice = basicPrice + (days - 30) * (getDailyPrice() * 0.1) * load;
        }
        return totalPrice;
    }
}
