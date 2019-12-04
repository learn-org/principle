package com.learn.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


/**
 * @author： lxj
 * @date： 2019/12/4
 * @description：
 */
public class CountTask extends RecursiveTask<Long> {
    private static final long THRESHOLD = 10000L;
    private long start;
    private long end;

    public CountTask(long start, long end){
        this.start = start;
        this.end = end;
    }



    @Override
    protected Long compute() {
        long sum = 0L;
        boolean canCompute = end - start < THRESHOLD;
        if (canCompute){
            for (long i = start; i <= end; i++){
                sum += i;
            }
        }else{
            long step = (start + end) / 100;
            long pos = start;
            List<CountTask> subTasks = new ArrayList<>();
            for (int j = 0; j < 100; j++){
                long lastOne = pos + step;
                if (lastOne > end){
                    lastOne = end;
                }
                CountTask countTask = new CountTask(pos, lastOne);
                subTasks.add(countTask);
                pos += step + 1;
                countTask.fork();
            }

            for (CountTask c : subTasks){
                sum += c.join();
            }
        }

        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask c = new CountTask(0L, 20000L);
        ForkJoinTask<Long> forkJoinTask = forkJoinPool.submit(c);
        long result = forkJoinTask.get();
        System.out.println("sum = "+result);
    }
}
