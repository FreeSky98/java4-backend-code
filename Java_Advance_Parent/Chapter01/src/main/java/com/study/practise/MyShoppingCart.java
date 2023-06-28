package com.study.practise;

import java.util.*;

public class MyShoppingCart {
    private static final Map<Long,CartItem> CART_MAP = new HashMap<>();
    private static final List<Goods> goodsList = new LinkedList<>();
    static {
        Goods g1 = new Goods(660294697L,"iPhone14",5899,100);
        Goods g2 = new Goods(11187899881L,"红米Note11T",1899,50);
        Goods g3 = new Goods(11155235371L,"荣耀畅玩30",1065,40);
        CART_MAP.put(g1.getId(),new CartItem(g1,1));
        CART_MAP.put(g2.getId(),new CartItem(g2,1));
        CART_MAP.put(g3.getId(),new CartItem(g3,1));

        goodsList.add(g1);
        goodsList.add(g2);
        goodsList.add(g3);
    }
    //1.显示购物车商品信息
    public static List<CartItem> getCartItems() {
        if (CART_MAP.isEmpty()) {
            throw new RuntimeException("购物车为空");
        }
        Collection<CartItem> cartItems = CART_MAP.values();
        return new ArrayList<>(cartItems);
    }
    //通过商品编号获取商品对象
    private static Goods getGoodsById(long goodsId) {
        if(!goodsList.isEmpty()) {
            for (Goods goods : goodsList) {
                if(goods != null && goods.getId() == goodsId) {
                    return goods;
                }
            }
        }
        return null;
    }

    //2.将挑选的商品放入购物车中
    public static boolean addToCart(long goodsId) {
        if(CART_MAP.containsKey(goodsId)) {
            CartItem cartItem = CART_MAP.get(goodsId);
            int currentQuantity  = cartItem.getQuantity();
            cartItem.setQuantity(currentQuantity  + 1);
            CART_MAP.put(goodsId, cartItem);
        }
        else {
            CART_MAP.put(goodsId,new CartItem(getGoodsById(goodsId), 1));
        }
        return true;
    }
    //3.将商品从购物车移除
    public static void removeFromCart(long goodsId) throws Exception {
        if (!CART_MAP.containsKey(goodsId)) {
            throw new Exception("商品编号不存在");
        }
        CartItem cartItem = CART_MAP.get(goodsId);
        int currentQuantity = cartItem.getQuantity();
        if (currentQuantity > 1) {
            cartItem.setQuantity(currentQuantity - 1);
            CART_MAP.put(goodsId,cartItem);
        }
        else {
            CART_MAP.remove(goodsId);
        }
    }
    //4.清空购物车
    public static void clearCart() throws Exception {
        if (!CART_MAP.isEmpty()) {
            CART_MAP.clear();
        }
        else {
            throw new Exception("购物车已为空！");
        }
    }
    //5.计算总金额
    public static double calculateTotalCost() {
        double totalCost = 0;
        if (CART_MAP.isEmpty()) {
            return totalCost;
        }
        else {
            Iterator<Map.Entry<Long,CartItem>> entryIt = CART_MAP.entrySet().iterator();
            while (entryIt.hasNext()) {
                Map.Entry<Long, CartItem> next =  entryIt.next();
                CartItem cartItem = next.getValue();
                totalCost += cartItem.getSubTotal();
            }
            return totalCost;
        }
    }
    //6.更改购物车中商品购买数量
    public static void changeQuantity(long goodsId,int quantity) throws Exception {
        if (!CART_MAP.containsKey(goodsId)) {
            throw new Exception("商品编号不存在!");
        }
        CartItem cartItem = CART_MAP.get(goodsId);
        if (quantity > cartItem.getGoods().getStock()) {
            throw new Exception("库存紧张！");
        }
        cartItem.setQuantity(quantity);
        CART_MAP.put(goodsId,cartItem);
    }
}
