package com.learn.thread;

/**
 * @author： lxj
 * @date： 2019/11/26
 * @description：
 */
public class SuspendAndResume {

    public static Object u=new Object();

    static ChangeObjectThread t1=new ChangeObjectThread("T1");
    static ChangeObjectThread t2=new ChangeObjectThread("T2");

    public static class ChangeObjectThread extends Thread{
        public ChangeObjectThread(String name){
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u){
                System.out.println("IN："+getName());
                Thread.currentThread().suspend();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.resume();
        t2.resume();
        System.out.println("T1 status："+t1.getState());
        System.out.println("T2 status："+t2.getState());
        t1.join();
        t2.join();
        System.out.println("T1 status："+t1.getState());
        System.out.println("T2 status："+t2.getState());

    }
}
