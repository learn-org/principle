package com.learn.thread;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author： lxj
 * @date： 2019/12/2
 * @description：
 */
public class RateLimiterExplain {

    static RateLimiter rateLimiter = RateLimiter.create(2);

    public static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"==="+System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++){
           /* rateLimiter.acquire();
            new Thread(new Task()).start();*/
           if (!rateLimiter.tryAcquire()){
               continue;
           }
            new Thread(new Task()).start();
        }
    }

}
