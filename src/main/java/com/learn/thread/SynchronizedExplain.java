package com.learn.thread;

/**
 * @author： lxj
 * @date： 2019/11/27
 * @description：
 */
public class SynchronizedExplain {
    /*
     *1，多个线程中，每个线程中创建一个对象访问同一个同步实例方法，异步访问。
     *2，多个线程中，每个线程中创建一个对象访问不同的同步实例方法，异步访问。
     *3，多个线程中，同一个对象实例访问不同的同步实例方法，同步访问。
     *4，多个线程中，每个线程中创建一个对象实例访问类方法的不同的同步方法，同步访问。
     *5，多个线程中，类名访问类方法的不同的同步方法，同步访问。
     *6，多个线程中，每个线程中创建一个对象实例访问类方法的同一个同步方法，同步访问。
     *7，多个线程中，每个线程中创建一个对象实例，一个线程中访问类方法的同步方法，一个线程中访问实例方法的同步方法，异步访问。
     *8，多个线程中，每个线程中创建一个对象实例，一个线程中类名访问类方法的同步方法，一个线程中实例对象访问实例方法的同步方法，异步访问。
     *9，多个线程中，每个线程中创建一个对象实例，一个线程中类名访问类方法的一个同步方法，一个线程中实例对象访问类方法的另一个同步方法，同步访问。
     *10，多个线程中，每个线程中创建一个对象实例，一个线程中类名和对象实例访问类方法的同一个同步方法，同步访问。
     *
     */

    public  synchronized void  synchronizedMethod() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"############实例同步方法############"+System.currentTimeMillis());
        Thread.sleep(6000);
    }
    public  synchronized void  synchronizedMethod1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"############实例同步方法############"+System.currentTimeMillis());
        Thread.sleep(5000);
    }
    public  synchronized static void  synchronizedStaticMethod() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"############类同步方法############"+System.currentTimeMillis());
        Thread.sleep(4000);

    }
    public  synchronized static void  synchronizedStaticMethod1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"############类同步方法############"+System.currentTimeMillis());
        Thread.sleep(3000);

    }

    public static void main(String[] args) {
        SynchronizedExplain synchronizedExplain=new SynchronizedExplain();
        SynchronizedExplain synchronizedExplain1=new SynchronizedExplain();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronizedExplain.synchronizedMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    SynchronizedExplain.synchronizedStaticMethod();
                    synchronizedExplain1.synchronizedMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.setName("T1");
        t2.setName("T2");
        t1.start();
        t2.start();
    }
}
