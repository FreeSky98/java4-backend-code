package com.kgc.rent;

public class Car extends Vehicle{
    private String type;

    public Car(String licenseNo, String brand, double dailyPrice, String type) {
        super(licenseNo, brand, dailyPrice);
        this.setType(type);
    }

    public Car() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public double getTotalPrice(int days) {
        double total;
        double discount;
        if (days > 150) {
            discount = 0.7;
        } else if (days > 30) {
            discount = 0.8;
        } else if (days > 7) {
            discount = 0.9;
        } else {
            discount = 1;
        }
        total = this.getDailyPrice() * days * discount;
        return total;
    }
}
