package com.learn.thread;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author： lxj
 * @date： 2019/7/16
 * @description：
 */
public class ThreadRealize {

    public static void main(String[] args) throws InterruptedException {
       Enum NEW=Thread.State.NEW;
       Runnable runnable=new Runnable() {
           @Override
           public void run() {
               System.out.println("runnable");
           }
       };
        Thread thread=new Thread(runnable);
        thread.start();
//        thread.join();
        System.out.println("main");
        ReentrantReadWriteLock reentrantReadWriteLock=new ReentrantReadWriteLock();
        reentrantReadWriteLock.readLock();
        ReentrantLock reentrantLock=new ReentrantLock();
        reentrantLock.lock();

    }

    private static void test(){
        System.out.println("test");

    }
    private  void test1(){
        test();
    }
}
