package com.learn.designmode.observer;

/**
 * @author: lxj
 * @Date: 2021/6/23
 * @Description:
 */

public class FailObserver implements Observer{
    @Override
    public void sendMessage() {
        System.out.println("失败了");
    }
}
