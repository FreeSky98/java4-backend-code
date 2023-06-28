package com.online.pet;

public class Dog extends Pet{

    public void setSex(int choose) {
        if (choose == 1 || choose == 2) {
            switch (choose) {
                case 1 -> this.sex ="帅哥狗仔";
                case 2 -> this.sex ="美女狗狗";
            }
        } else {
            System.out.println("性别只能是美女狗狗或帅哥狗仔，否则取默认值为美女狗狗");
            this.sex = "美女狗狗";
        }
    }
}
