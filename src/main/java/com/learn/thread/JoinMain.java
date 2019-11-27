package com.learn.thread;

/**
 * @author： lxj
 * @date： 2019/11/26
 * @description：
 */
public class JoinMain {

    public volatile static int i=0;

    public static class JoinThread extends Thread{
        @Override
        public void run() {
            for (i=0;i<10000;i++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinThread joinThread=new JoinThread();
        joinThread.setName("joinThread");
        Thread.currentThread().setName("main######");
        System.out.println("Thread current1："+Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isDaemon()："+Thread.currentThread().isDaemon());
        joinThread.start();
        joinThread.join();
        System.out.println("Thread current2："+Thread.currentThread());
        System.out.println(i);
    }

}
