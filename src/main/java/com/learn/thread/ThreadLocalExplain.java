package com.learn.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author： lxj
 * @date： 2019/12/4
 * @description：
 */
public class ThreadLocalExplain {

//    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<>();

    public static class ParseDate implements Runnable{
        int i = 0;
        public ParseDate(int i){
            this.i = i;
        }
        @Override
        public void run() {
            try {
                if (sdf.get() == null){
                    sdf.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                }
                Date t = sdf.get().parse("2019-12-04 16:50:"+i%60);
                System.out.println(i+"："+t);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0; i < 1000; i++){
            executorService.execute(new ParseDate(i));
        }
        executorService.shutdown();
    }
}
