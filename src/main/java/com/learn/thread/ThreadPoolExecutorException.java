package com.learn.thread;

import java.util.concurrent.*;

/**
 * @author: lxj
 * @Date: 2020/6/12
 * @Description:  当线程池中的某个线程报错，如果捕获异常，则不影响其它线程的执行。如果不捕获异常，使用execute执行，不影响其它线程执行。
 *                如果使用submit执行，如果不调用Future的get()方法，则不影响其它线程，否则后续线程不执行。
 */

public class ThreadPoolExecutorException {

    public static class ExceptionTask implements Runnable{
        private String msg;
        private String name;
        public ExceptionTask(String name){
            this.name = name;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        @Override
        public void run() {
            try{
                if("E".equals(name)){
                    System.out.println(1/0);
                }
                System.out.println(name + "正在执行......");
            }catch (Exception e){
                System.out.println(name + "报错了.......");
                msg = e.getMessage();
            }
           /* if("E".equals(name)){
                System.out.println(1/0);
            }
            System.out.println(name + "正在执行......");*/
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100));
        for(int i = 0; i < 5; i++){
            ExceptionTask e;
            if(i == 3){
                e = new ExceptionTask("E");
            }else {
                e = new ExceptionTask("E-" + i);
            }
//            threadPoolExecutor.execute(e);
            Future f = threadPoolExecutor.submit(e);
            f.get();
            System.out.println("返回值："+f.get());
            System.out.println("error:"+e.getMsg());
            System.out.println(Runtime.getRuntime().availableProcessors());
            System.out.println(Runtime.getRuntime().totalMemory());
            System.out.println(Runtime.getRuntime().freeMemory());
            System.out.println(Runtime.getRuntime().maxMemory());
        }
    }
}
