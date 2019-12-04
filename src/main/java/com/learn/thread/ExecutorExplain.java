package com.learn.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author： lxj
 * @date： 2019/12/2
 * @description：
 */
public class ExecutorExplain {

    public static void main(String[] args) {
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(1);
        Executors.newSingleThreadExecutor();
        Executors.newSingleThreadScheduledExecutor();
        Executors.newScheduledThreadPool(1);
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
//        threadPoolExecutor.execute();
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);

    }
}
