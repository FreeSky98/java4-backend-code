package lesson01;

public class Goods {
    String goodsName;
    double goodsPrice;
    int goodsStock;
    public void showGoodsInfo() {
        System.out.println("商品名称：" + this.goodsName);
        System.out.println("商品价格：" + this.goodsPrice);
        System.out.println("商品库存：" + this.goodsStock);
    }//显示方法
    public Goods(String name,double goodsPrice,int goodsStock) {
        this.goodsName = name;
        this.goodsPrice = goodsPrice;
        this.goodsStock = goodsStock;
    }//构造方法
    public static void discount(Goods goodsRef,double rate) {
        goodsRef.goodsPrice = goodsRef.goodsPrice * rate;
        goodsRef.goodsStock = goodsRef.goodsStock - 1;
    }//利用对象作为参数的方法
}

class GoodsTest {
    public static void main(String[] args) {
        Goods goods = new Goods("小米13Pro",5799.00,1000);
        goods.showGoodsInfo();
        System.out.println();

        double rate = 0.7;
        Goods.discount(goods,rate);

        System.out.println("打折后的商品价格是：");
        goods.showGoodsInfo();
    }
}
