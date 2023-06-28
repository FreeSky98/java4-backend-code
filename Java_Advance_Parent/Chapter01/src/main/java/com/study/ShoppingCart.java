package com.study;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    //使用HashMap<K,V>模拟购物车业务
    //需求：
    //1.将商品放入购物车中（已放入购物车中商品再次加入，数量加1）
    //2.将商品从购物车中移除（如果购物车中商品数量大于1，数量减1）
    //3.展示购物车中所有商品信息列表
    //4.清空购物车
    //5.更改购物车中商品购买数量（小计和总计重新计算）
    //6.计算购物车中商品总消费金额
    //7.创建订单
    private Map<String, Integer> cart; // 购物车，键为商品名称，值为商品数量
    private Map<String, Double> prices; // 商品价格表，键为商品名称，值为商品价格

    public ShoppingCart(Map<String, Double> prices) {
        this.cart = new HashMap<>();
        this.prices = prices;
    }

    // 将商品放入购物车中
    public void addProduct(String productName) {
        if (cart.containsKey(productName)) {
            cart.put(productName, cart.get(productName) + 1);
        } else {
            cart.put(productName, 1);
        }
    }

    // 将商品从购物车中移除
    public void removeProduct(String productName) {
        if (cart.containsKey(productName)) {
            int count = cart.get(productName);
            if (count > 1) {
                cart.put(productName, count - 1);
            } else {
                cart.remove(productName);
            }
        }
    }

    // 展示购物车中所有商品信息列表
    public void showCart() {
        System.out.println("商品名称\t数量\t单价\t小计");
        double total = 0;
        for (String productName : cart.keySet()) {
            int count = cart.get(productName);
            double price = prices.get(productName);
            double subtotal = count * price;
            System.out.printf("%s\t%d\t%.2f\t%.2f\n", productName, count, price, subtotal);
            total += subtotal;
        }
        System.out.printf("总计：%.2f\n", total);
    }

    // 清空购物车
    public void clearCart() {
        cart.clear();
    }

    // 更改购物车中商品购买数量
    public void updateProductCount(String productName, int count) {
        if (cart.containsKey(productName)) {
            if (count > 0) {
                cart.put(productName, count);
            } else {
                cart.remove(productName);
            }
        }
    }

    // 计算购物车中商品总消费金额
    public double getTotalPrice() {
        double total = 0;
        for (String productName : cart.keySet()) {
            int count = cart.get(productName);
            double price = prices.get(productName);
            double subtotal = count * price;
            total += subtotal;
        }
        return total;
    }

    // 创建订单
    public void createOrder() {
        System.out.println("订单已创建，总金额为：" + getTotalPrice());
    }
}

class Main {
    public static void main(String[] args) {
        Map<String, Double> prices = new HashMap<>();
        prices.put("苹果", 5.0);
        prices.put("香蕉", 3.0);
        prices.put("橙子", 4.0);

        ShoppingCart cart = new ShoppingCart(prices);
        cart.addProduct("苹果");
        cart.addProduct("苹果");
        cart.addProduct("香蕉");
        cart.addProduct("橙子");
        cart.showCart();

        cart.removeProduct("苹果");
        cart.showCart();

        cart.updateProductCount("香蕉", 3);
        cart.showCart();

        cart.clearCart();
        cart.showCart();

        cart.createOrder();
    }
}