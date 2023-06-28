package com.wqq.zoo;

public class Cat extends Animal implements Terrestrial{
    private int legNum;//腿数
    public Cat(String name,int legNum) {
        super(name);
        this.legNum = legNum;
    }

    public Cat() {

    }

    public int getLegNum() {
        return legNum;
    }

    @Override
    public void shout() {
        System.out.println("喵喵喵......");
    }
}
