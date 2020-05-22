package com.learn.designmode.singleton;

/**
 * @author: lxj
 * @Date: 2020/5/11
 * @Description: 设计模式-单例模式（DCL 双重检查锁）
 */

public class Singleton {
    private static volatile Singleton singleton = null;
    private Singleton(){

    }
    public static Singleton getSingleton(){
        if(singleton == null){
            synchronized(Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        Singleton singleton = new Singleton();
        Singleton.getSingleton();
    }
}
