package com.learn.thread;

import java.util.concurrent.*;

/**
 * @author： lxj
 * @date： 2019/7/25
 * @description：
 */
public class ThreadPoolRealize {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(10,10,10, TimeUnit.MINUTES,new LinkedBlockingDeque<>(),new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("测试");
            }
        });
        threadPoolExecutor.shutdown();
        if(threadPoolExecutor.isShutdown()){
            System.out.println("线程池已经停止");
        }

    }

    public class ThreadPool extends ThreadPoolExecutor{
        public ThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        @Override
        protected void beforeExecute(Thread t, Runnable r) {
            super.beforeExecute(t, r);
        }
    }

}
