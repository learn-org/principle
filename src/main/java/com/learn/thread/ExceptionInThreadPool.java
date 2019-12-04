package com.learn.thread;

import java.util.concurrent.*;

/**
 * @author： lxj
 * @date： 2019/12/3
 * @description：
 */
public class ExceptionInThreadPool {

    public static class DivTask implements Runnable{

        public int a;
        public int b;

        public DivTask(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            System.out.println(a/b);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new TraceThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());

        for (int i=0; i < 5; i++){
            threadPoolExecutor.execute(new DivTask(100, i));
//            Future f = threadPoolExecutor.submit(new DivTask(100, i));
//            f.get();
        }

        threadPoolExecutor.shutdown();
    }
}
