package org.example.v1;

import java.lang.reflect.InvocationTargetException;

/**
 * 静态商品工厂类
 */
public class GoodsFactory {
    public static IGoods createGoods(String className){
//        IGoods goods = null;//接口引用变量
//        if ("tv".equalsIgnoreCase(str)){
//            goods = new TV();
//        } else if ("food".equalsIgnoreCase(str)){
//            goods = new Food();
//        }
//        return goods;
        try {
            Class<?> aClass = Class.forName(className);
            return (IGoods) aClass.getConstructor().newInstance();//创建某个类的实例newInstance()
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("赶快给我检查你给的类（限定名）是不是对的啊！");
            return null;
        }
    }
}
