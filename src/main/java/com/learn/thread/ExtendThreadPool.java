package com.learn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author： lxj
 * @date： 2019/12/3
 * @description：
 */
public class ExtendThreadPool {

    public static class MyTask implements Runnable{

        public String name;

        public MyTask(String name){
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println("线程"+name+"正在执行，Thread ID："+Thread.currentThread().getId());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = new ThreadPoolExecutor(5, 5,
                                      0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>()){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("将要执行的线程："+((MyTask)r).name);
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完的线程："+((MyTask)r).name);
            }

            @Override
            protected void terminated() {
                System.out.println("线程池结束");
            }
        };

        for (int i=0; i < 5; i++){
            MyTask myTask = new MyTask("TASK-"+i);
            es.execute(myTask);
            Thread.sleep(10);
        }

        es.shutdown();

    }
}
