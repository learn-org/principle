package com.learn.thread;

import com.sun.org.apache.xalan.internal.utils.FeatureManager;

import java.util.concurrent.*;

/**
 * @author： lxj
 * @date： 2019/7/25
 * @description：
 */
public class ThreadPool extends ThreadPoolExecutor {
    public ThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        System.out.println("beforeExecute");
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        System.out.println("afterExecute");
    }

    @Override
    protected void terminated() {
        System.out.println("线程池结束");
    }

    public static void main(String[] args) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("线程执行");
            }
        };
        ThreadPool threadPool=new ThreadPool(1,2,10,TimeUnit.MINUTES,new LinkedBlockingDeque<>());
        threadPool.execute(runnable);
        threadPool.shutdown();
        threadPool.prestartAllCoreThreads();
//        FutureTask futureTask=(FutureTask)threadPool.submit(runnable);
//        System.out.println(futureTask.isDone());

    }
}
