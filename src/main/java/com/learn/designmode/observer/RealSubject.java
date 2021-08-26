package com.learn.designmode.observer;

/**
 * @author: lxj
 * @Date: 2021/6/23
 * @Description:
 */

public class RealSubject extends Subject{

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        SuccessObserver successObserver = new SuccessObserver();
        FailObserver failObserver = new FailObserver();
        realSubject.addObserver(successObserver);
        realSubject.addObserver(failObserver);
        realSubject.notifyObserver();
        System.out.println("##################################################");
        realSubject.deleteObserver(successObserver);
        realSubject.notifyObserver();
    }
}
