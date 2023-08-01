package org.example.v1;

public class TV implements IGoods {

    public TV() {
    }

    @Override
    public void printPrice() {
        System.out.println("输出电视价格");
    }
}
