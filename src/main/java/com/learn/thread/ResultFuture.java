package com.learn.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author: lxj
 * @Date: 2020/6/24
 * @Description:
 */

public class ResultFuture<V> implements Future {

    private final V v;

    private final Throwable throwable;

    public ResultFuture(V v){
        this(v, null);
    }

    public ResultFuture(V v, Throwable throwable){
        this.v = v;
        this.throwable = throwable;
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public Object get() throws InterruptedException, ExecutionException {
        return this.v;
    }

    @Override
    public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
