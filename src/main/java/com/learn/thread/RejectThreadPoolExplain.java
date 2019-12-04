package com.learn.thread;

import java.util.concurrent.*;

/**
 * @author： lxj
 * @date： 2019/12/2
 * @description：
 */
public class RejectThreadPoolExplain {

    public static class MyTask implements Runnable{

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis()+"：ThreadId："+Thread.currentThread().getId());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0L,
                        TimeUnit.MILLISECONDS,
                        new LinkedBlockingDeque<>(10),
                (r)-> {
                    Thread thread = new Thread(r);
                    thread.setName("T");
                    return thread;
                },
                (r, executor) -> System.out.println(r.toString() +"is discard"));
        MyTask myTask = new MyTask();
        for (int i=0; i < Integer.MAX_VALUE; i++){
            threadPoolExecutor.submit(myTask);
            Thread.sleep(10);
        }
    }
}
