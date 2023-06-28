package com.wqq.zoo;

public class Duck extends Animal implements Terrestrial{
    private int legNum;//腿数

    public Duck(String name, int legNum) {
        super(name);
        this.legNum = legNum;
    }
    public Duck() {

    }

    public int getLegNum() {
        return legNum;
    }

    @Override
    public void shout() {
        System.out.println("嘎嘎嘎......");
    }
}

