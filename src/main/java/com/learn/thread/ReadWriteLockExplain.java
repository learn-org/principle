package com.learn.thread;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author： lxj
 * @date： 2019/11/27
 * @description：
 */
public class ReadWriteLockExplain {
    /*
     *读取数据时，读写锁ReentrantReadWriteLock比ReentrantLock效率高。因为读写锁的读锁是同时执行的，ReentrantLock的锁需要等待。
     */

    private static Lock lock=new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    private static Lock readLock=readWriteLock.readLock();
    private static Lock writeLock=readWriteLock.writeLock();
    private static int value=0;
    public Object handleRead(Lock lock){
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"==读锁开始："+System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"==读锁结束："+System.currentTimeMillis());
            return value;
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
        return value;
    }
    public void handleWrite(Lock lock, int index){
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"==写锁开始："+System.currentTimeMillis());
            Thread.sleep(1000);
            value=index;
            System.out.println(Thread.currentThread().getName()+"==写锁结束："+System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockExplain readWriteLockExplain=new ReadWriteLockExplain();

        Runnable read=new Runnable() {
            @Override
            public void run() {
//                readWriteLockExplain.handleRead(readLock);
                readWriteLockExplain.handleRead(lock);
            }
        };
        Runnable write=new Runnable() {
            @Override
            public void run() {
//                readWriteLockExplain.handleWrite(writeLock, new Random().nextInt());
                readWriteLockExplain.handleWrite(lock, new Random().nextInt());
            }
        };

        for (int i=0;i<18;i++){
            new Thread(read).start();
        }
        for (int j=18;j<20;j++){
            new Thread(write).start();
        }
    }

}
