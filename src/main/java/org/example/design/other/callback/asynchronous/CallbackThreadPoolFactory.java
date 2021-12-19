package org.example.design.other.callback.asynchronous;


import com.google.common.base.Preconditions;
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
 *  CallbackThreadPool单例工厂类
 *
 * Author: GL
 * Date: 2021-10-25
 */
public enum CallbackThreadPoolFactory {
    ;// 无实例，对外只开放静态函数

    public static CallbackThreadPool create(int poolSize, int timeOut) {
        return new CallbackThreadPool(poolSize, timeOut);
    }

    public static CallbackThreadPool create() {
        return new CallbackThreadPool(1, 60);
    }


    /**
     *  异步调用线程池，核心采用google的ListeningExecutorService线程池完成，通过泛型方法实现类型兼容
     *  默认线程池大小为poolSize = 5，监控超时线程池大小poolOutTimeSize = 1
     */
    static class CallbackThreadPool {
        private final int timeOut;  // 线程超时时间-单位秒
        private final ScheduledThreadPoolExecutor timerService;
        private final ExecutorService callBackService;
        private final ListeningExecutorService services;

        // 线程安全
        public synchronized <E> void addCallable(Callable<E> call, FutureCallback<E> futureCallback) {
            if (Objects.nonNull(call) && Objects.nonNull(futureCallback)) {
                onReceive(call, futureCallback);
            }
        }

        private <E> void onReceive(Callable<E> call, FutureCallback<E> futureCallback) {
            try {
                final ListenableFuture<E> resultFuture = services.submit(call);
                ListenableFuture<E> timeoutFuture = withTimeout(resultFuture, timeOut, TimeUnit.SECONDS, timerService);
                addCallback(timeoutFuture, futureCallback, callBackService);
            } catch (Exception e) {
                System.out.println("创建异常");
            }
        }

        private CallbackThreadPool(int poolSize, int timeOut) {
            Preconditions.checkArgument(poolSize > 0 && timeOut > 0, "线程池数量不能小于等于0");
            this.timeOut = timeOut;
            int poolOutTimeSize = 1;
            this.timerService = new ScheduledThreadPoolExecutor(poolOutTimeSize);
            this.callBackService = Executors.newFixedThreadPool(poolSize);
            this.services = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(poolSize));
        }
    }
}
