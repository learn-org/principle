package com.learn.designmode.factory;

/**
 * @author: lxj
 * @Date: 2020/5/11
 * @Description:
 */

public class FruitFactory {
    public Fruit getInstance(Class clazz){
        Fruit fruit = null;
        try {
            fruit = (Fruit) clazz.newInstance();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取水果实例异常");
        }
        return fruit;
    }

    public static void main(String[] args) {
        FruitFactory fruitFactory = new FruitFactory();
        Fruit orange = fruitFactory.getInstance(Orange.class);
        orange.species();
        orange.color();
        orange.taste();
        System.out.println("##################################################################");
        Fruit banana = fruitFactory.getInstance(Banana.class);
        banana.species();
        banana.color();
        banana.taste();
    }
}
