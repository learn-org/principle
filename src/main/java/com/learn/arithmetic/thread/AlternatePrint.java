package com.learn.arithmetic.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: lxj
 * @Date: 2021/8/5
 * @Description: 两个线程交替输出，输出为1A2B3C4D5E6F7G8H9I
 */

public class AlternatePrint {
    private static Thread t1 = null;
    private static Thread t2 = null;
    public static void main(String[] args) {
        char[] numberArr = "123456789".toCharArray();
        char[] letterArr = "ABCDEFGHI".toCharArray();
//        alternatePrintLockSupport(numberArr, letterArr);
//        alternatePrintCondition(numberArr, letterArr);
        alternatePrintWait(numberArr, letterArr);
    }

    private static void alternatePrintLockSupport (char[] numberArr, char[] letterArr) {
        t1 = new Thread(()->{
            for (char a : numberArr) {
                System.out.print(a);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");
        t2 = new Thread(()->{
            for (char a : letterArr) {
                LockSupport.park();
                System.out.print(a);
                LockSupport.unpark(t1);
            }
            System.out.println();
        }, "t2");
        t1.start();
        t2.start();
    }
    private static void alternatePrintCondition (char[] numberArr, char[] letterArr) {
        Lock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        new Thread(()->{
            try {
                lock.lock();
                for (char a : numberArr) {
                    System.out.print(a);
                    c2.signal();
                    c1.await();
                }
                c2.signal();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }, "t1").start();
        new Thread(()->{
            try {
                lock.lock();
                for (char a : letterArr) {
                    System.out.print(a);
                    c1.signal();
                    c2.await();
                }
                c1.signal();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
           System.out.println();
        }, "t2").start();

    }
    private static void alternatePrintWait (char[] numberArr, char[] letterArr) {
        Object o = new Object();
        t1 = new Thread(()->{
            synchronized (o) {
                for (char a : numberArr) {
                    System.out.print(a);
                    try {
                        o.notify();
                        // 让出锁
                        o.wait();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t1");
        t2 = new Thread(()->{
           synchronized (o) {
               for (char a : letterArr) {
                   System.out.print(a);
                   try {
                       o.notify();
                       // 让出锁
                       o.wait();
                   } catch (InterruptedException interruptedException) {
                       interruptedException.printStackTrace();
                   }
               }
               o.notify();
           }
           System.out.println();
        }, "t2");
        t1.start();
        t2.start();
    }
}
