package com.kgc.rent;

public class Bus extends Vehicle{
    private int seatCount;

    public Bus() {

    }

    public Bus(String licenseNo, String brand, double dailyPrice, int seatCount) {
        super(licenseNo, brand, dailyPrice);
        this.setSeatCount(seatCount);
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    @Override
    public double getTotalPrice(int days) {
        double total;
        double discount;
        if (days >= 150) {
            discount = 0.6;
        } else if (days >= 30) {
            discount = 0.7;
        } else if (days >= 7) {
            discount = 0.8;
        } else if (days >= 3) {
            discount = 0.9;
        } else {
            discount = 1;
        }
        total = this.getDailyPrice() * days * discount;
        return total;
    }
}
