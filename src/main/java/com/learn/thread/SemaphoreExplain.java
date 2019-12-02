package com.learn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author： lxj
 * @date： 2019/11/27
 * @description：
 */
public class SemaphoreExplain implements Runnable{
    final Semaphore semaphore=new Semaphore(5);


    @Override
    public void run() {
        try {
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId()+" done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            semaphore.release();
        }
    }

    public static void main(String[] args) {
       /* ExecutorService executorService=Executors.newFixedThreadPool(20);
        SemaphoreExplain semaphoreExplain=new SemaphoreExplain();
        for(int i=0;i<20;i++){
            executorService.submit(semaphoreExplain);
        }*/
        Semaphore sem=new Semaphore(5);
       for (int i=0;i<8;i++){
           new Worker(i, sem).start();
       }
    }

    /**
     * 8个工人使用5台机器
     */
    static class Worker extends Thread{
        private int num;
        private Semaphore semaphore;
        public Worker(int num, Semaphore semaphore){
            this.num=num;
            this.semaphore=semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("worker-"+num+"占用机器"+Thread.currentThread().getName());
                Thread.sleep(1000);
                semaphore.release();
                System.out.println("worker-"+num+"释放机器"+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
