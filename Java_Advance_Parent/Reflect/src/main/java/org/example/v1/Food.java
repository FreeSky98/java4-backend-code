package org.example.v1;

public class Food implements IGoods {

    @Override
    public void printPrice() {
        System.out.println("输出食品价格");
    }

    public Food() {
    }
}
