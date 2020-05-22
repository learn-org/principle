package com.learn.designmode.factory;

/**
 * @author: lxj
 * @Date: 2020/5/11
 * @Description:
 */

public class Banana implements Fruit {
    @Override
    public void species() {
        System.out.println("我是香蕉");
    }

    @Override
    public void color() {
        System.out.println("是黄色的");
    }

    @Override
    public void taste() {
        System.out.println("是甜的");
    }
}
