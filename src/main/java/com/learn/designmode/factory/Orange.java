package com.learn.designmode.factory;

import com.learn.designmode.factory.Fruit;

/**
 * @author: lxj
 * @Date: 2020/5/11
 * @Description:
 */

public class Orange implements Fruit {
    @Override
    public void species() {
        System.out.println("我是橘子！");
    }

    @Override
    public void color() {
        System.out.println("是黄色的！");
    }

    @Override
    public void taste() {
        System.out.println("是酸酸甜甜的！");
    }
}
