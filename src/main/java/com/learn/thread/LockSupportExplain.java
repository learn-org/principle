package com.learn.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @author： lxj
 * @date： 2019/12/2
 * @description：
 */
public class LockSupportExplain {

    static Object object = new Object();

    static ChangeObjectThread t1 = new ChangeObjectThread("T1");
    static ChangeObjectThread t2 = new ChangeObjectThread("T2");


    public static class ChangeObjectThread extends Thread{

        String threadName;

        public ChangeObjectThread(String threadName){
            this.threadName = threadName;
        }

        @Override
        public void run(){
            synchronized (object){
                System.out.println("测试LockSupport......park开始");
                LockSupport.park();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        t1.join();
        LockSupport.unpark(t1);
        System.out.println("测试LockSupport......unpark结束");

    }
}
