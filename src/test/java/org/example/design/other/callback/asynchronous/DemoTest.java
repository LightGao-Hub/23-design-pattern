package org.example.design.other.callback.asynchronous;

import com.google.common.util.concurrent.FutureCallback;

/**
 *  测试线程池及线程池超时功能，十秒后超时异常处理后结束
 * Author: GL
 * Date: 2021-10-25
 */
public class DemoTest {
    public static void main(String[] a) {
        CallbackThreadPoolFactory.CallbackThreadPool callbackThreadPool = CallbackThreadPoolFactory.create(5, 10);
        callbackThreadPool.addCallable(new DemoCallableThreadPool(), new FutureCallback<String>() {
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
