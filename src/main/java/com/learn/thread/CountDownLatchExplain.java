package com.learn.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author： lxj
 * @date： 2019/11/27
 * @description：
 */
public class CountDownLatchExplain implements Runnable {
    /*
     *模拟火箭发射：发射之前的检查工作完成后才发射火箭。
     */

    private static CountDownLatch countDownLatch = new CountDownLatch(10);


    @Override
    public void run() {
        try{
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println("检查完毕！");
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            countDownLatch.countDown();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatchExplain countDownLatchExplain = new CountDownLatchExplain();
        for (int i=0; i<10; i++){
            executorService.submit(countDownLatchExplain);
        }
        countDownLatch.await();
        System.out.println("发射火箭！");
        executorService.shutdown();
    }
}
