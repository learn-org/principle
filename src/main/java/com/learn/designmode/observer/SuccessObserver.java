package com.learn.designmode.observer;

/**
 * @author: lxj
 * @Date: 2021/6/23
 * @Description:
 */

public class SuccessObserver implements Observer{
    @Override
    public void sendMessage() {
        System.out.println("成功了");
    }
}
