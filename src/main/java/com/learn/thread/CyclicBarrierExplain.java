package com.learn.thread;

import java.io.ByteArrayInputStream;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author： lxj
 * @date： 2019/12/2
 * @description：
 */
public class CyclicBarrierExplain {


    public static class Soldier implements Runnable{

        private String soldierName;
        private final CyclicBarrier cyclicBarrier;

        Soldier(String soldierName, CyclicBarrier cyclicBarrier){
            this.soldierName = soldierName;
            this.cyclicBarrier = cyclicBarrier;

        }

        @Override
        public void run() {
            try {
                //等待所有士兵到齐
                cyclicBarrier.await();
                doWork();
                //等待所有士兵完成任务
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }

        void doWork(){
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(soldierName+"：任务完成");
        }
    }

    public static class BarrierRun implements Runnable{

        private boolean flag;
        private int n;

        public BarrierRun(boolean flag, int n){
            this.flag = flag;
            this.n = n;

        }

        @Override
        public void run() {
            if (flag){
                System.out.println("司令：[士兵"+n+"个，任务完成]");
            }else{
                System.out.println("司令：[士兵"+n+"个，集合完毕]");
                flag = true;
            }

        }
    }

    public static void main(String[] args) {
        int n = 10;
        Thread[] allSoldier = new Thread[10];
        boolean flag = false;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(n, new BarrierRun(flag, n));
        System.out.println("集合队伍");
        for (int i = 0; i < n; i++){
            System.out.println("士兵"+i+"报到");
            allSoldier[i] = new Thread(new Soldier("士兵"+i, cyclicBarrier));
            allSoldier[i].start();
        }
    }
}
