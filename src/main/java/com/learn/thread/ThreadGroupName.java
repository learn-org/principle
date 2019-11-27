package com.learn.thread;

/**
 * @author： lxj
 * @date： 2019/11/26
 * @description：
 */
public class ThreadGroupName implements Runnable{

    public static void main(String[] args) {
        /**
         * 线程组
         */
        ThreadGroup threadGroup=new ThreadGroup("printgroup");
        Thread t1=new Thread(threadGroup,new ThreadGroupName(),"T1");
        Thread t2=new Thread(threadGroup,new ThreadGroupName(),"T2");
        t1.start();
        t2.start();
        System.out.println("运行的线程数："+threadGroup.activeCount());
        threadGroup.list();
    }
    @Override
    public void run() {
        String groupAndName=Thread.currentThread().getThreadGroup().getName()+"__"+Thread.currentThread().getName();
        while (true){
            System.out.println("我是"+groupAndName);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
