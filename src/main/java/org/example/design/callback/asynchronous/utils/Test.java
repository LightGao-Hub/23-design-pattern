package org.example.design.callback.asynchronous.utils;

import com.google.common.util.concurrent.FutureCallback;

/**
 *  测试线程池工具类，十秒后超时结束
 * Author: GL
 * Date: 2021-10-25
 */
public class Test {
    public static void main(String[] args) {

        AsynchronousCallbackUtil<String> asynchronousCallbackUtil = AsynchronousFactory.create(5, 10);

        asynchronousCallbackUtil.addCallable(new DemoCallable(), new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println(" onSuccess result = " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println(" onFailure Throwable t.getMessage() = " + t.getMessage());
            }
        });

    }
}
