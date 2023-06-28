package com.online.pet;

public class Penguin extends Pet {

    public void setSex(int choose) {
        if (choose == 1 || choose == 2) {
            switch (choose) {
                case 1 -> this.sex ="Q仔";
                case 2 -> this.sex ="Q妹";
            }
        } else {
            System.out.println("性别只能是Q妹或Q仔，否则取默认值为Q妹");
            this.sex = "Q妹";
        }
    }
}
