package com.wqq.zoo;

public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public void shout() {

    }

    @Override
    public String toString() {
        return name + "\t\t\t";
    }
    public void showShout() {
        this.shout();
    }
}
