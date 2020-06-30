package com.learn.thread;

import com.learn.entity.Result;

import java.util.concurrent.*;

/**
 * @author： lxj
 * @date： 2019/12/3
 * @description：
 */
public class ExceptionInThreadPool {

    public static class DivTask implements Callable{

        public int a;
        public int b;

        public DivTask(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public Object call(){
            Result result = new Result();
            try{
                if(b == 2){
                    System.out.println(a / 0);
                }
                result.setMsg("返回值：" + b);
                System.out.println(a/(b+1));
            }catch (Exception e){
                result.setMsg("报错了。。。");
                return result;
            }
            return result;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new TraceThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());

        for (int i=0; i < 5; i++){
//            threadPoolExecutor.execute(new DivTask(100, i));
            Future<Result> f = threadPoolExecutor.submit(new DivTask(100, i));
            Object o = f.get();
            System.out.println("返回值：" + f.get().getMsg());
        }

        threadPoolExecutor.shutdown();
    }
}
