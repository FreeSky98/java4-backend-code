package org.example.v1;

import org.example.v2.PropsUtil;

public class Test {
    public static void main(String[] args) {
        IGoods goods = GoodsFactory.createGoods(PropsUtil.getValueByKey("className"));
        goods.printPrice();
    }
}
