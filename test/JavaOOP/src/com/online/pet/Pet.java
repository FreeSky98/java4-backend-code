package com.online.pet;

public class Pet {
    String name;
    String type;
    String sex;
    int health;//健康值
    int lovely;//亲密度

    public Pet(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 4) {
            this.name = name;
        } else {
            System.out.println("昵称是中文或字符2~4汉字，否则为无名");
            this.name = null;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(int choose) {
        if (choose == 1 || choose == 2) {
            switch (choose) {
                case 1 -> this.type = "狗狗";
                case 2 -> this.type= "企鹅";
            }
        } else {
            this.type = "企鹅";
        }
    }

    public String getSex() {
        return sex;
    }

    public void setSex(int choose) {
        if (choose == 1 || choose == 2) {
            switch (choose) {
                case 1 -> this.sex ="男性宠物";
                case 2 -> this.sex ="默认设置：女性宠物";
            }
        } else {
            System.out.println("性别只能是女性宠物或男性宠物，否则取默认值为女性宠物");
            this.sex = "女性宠物";
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health >= 0 && health <= 100) {
            this.health = health;
        } else {
            System.out.println("健康值应在0~100之间，默认是60");
            this.health = 60;
        }
    }

    public int getLovely() {
        return lovely;
    }

    public void setLovely(int lovely) {
        if (lovely >= 0 && lovely <= 100) {
            this.lovely = lovely;
        } else {
            System.out.println("健康值应在0~100之间，默认是60");
            this.lovely = 60;
        }
    }

    public void showPetInfo() {
        System.out.println("宠物的自白：");
        System.out.println("我的名字叫"+getName()+",健康值是"+getHealth()+",和主人的亲密度是"+getLovely()+"，我的性别是"+getSex());
    }
}

