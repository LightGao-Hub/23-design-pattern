package org.example.design.other.callback.asynchronous.utils;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.google.common.util.concurrent.Futures.addCallback;
import static com.google.common.util.concurrent.Futures.withTimeout;

/**
 *  此类有一个局限性是返回值类型必须是T, 固定类型的返回值T可以放多个不同的Callable线程
 * Author: GL
 * Date: 2021-10-25
 */
public final class AsynchronousCallbackUtil<T> {

    private int poolSize = 5;
    private int poolOutTimeSize = 1;
    private int timeOut = 60;  //单位秒
    private final ScheduledThreadPoolExecutor timerService;
    private final ExecutorService callBackService;
    private final ListeningExecutorService services;

    public synchronized void addCallable(Callable<T> call, FutureCallback<T> futureCallback) {
        if (Objects.nonNull(call) && Objects.nonNull(futureCallback)) {
            onReceive(call, futureCallback);
        }
    }

    private void onReceive(Callable<T> call, FutureCallback<T> futureCallback) {
        try {
            final ListenableFuture<T> resultFuture = services.submit(call);
            ListenableFuture<T> timeoutFuture = withTimeout(resultFuture, timeOut, TimeUnit.SECONDS, timerService);
            addCallback(timeoutFuture, futureCallback, callBackService);
        } catch (Exception e) {
            System.out.println("创建异常");
        }
    }

    AsynchronousCallbackUtil(int poolSize, int timeOut) {
        if (poolSize > 0 && timeOut > 0) {
            this.poolSize = poolSize;
            this.timeOut = timeOut;
        }
        this.timerService = new ScheduledThreadPoolExecutor(poolOutTimeSize);
        this.callBackService = Executors.newFixedThreadPool(this.poolSize);
        this.services = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(this.poolSize));
    }

}
