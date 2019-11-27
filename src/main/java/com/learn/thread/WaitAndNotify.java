package com.learn.thread;

/**
 * @author： lxj
 * @date： 2019/11/26
 * @description：
 */
public class WaitAndNotify {

    final static Object object=new Object();
    public static class T1 extends Thread{
        @Override
        public void run(){
            synchronized (object){
                System.out.println("T1 start："+System.currentTimeMillis());
                try {
                    System.out.println("T1 wait object："+System.currentTimeMillis());
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1 end："+System.currentTimeMillis());
            }

        }
    }
    public static class T2 extends Thread{
        @Override
        public void run(){
            synchronized (object){
                System.out.println("T2 start notify a object："+System.currentTimeMillis());
                object.notify();
                System.out.println("T2 end："+System.currentTimeMillis());
                try {
                   Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        T1 t1=new T1();
        T2 t2=new T2();
        t1.start();
        t2.start();
    }
}
