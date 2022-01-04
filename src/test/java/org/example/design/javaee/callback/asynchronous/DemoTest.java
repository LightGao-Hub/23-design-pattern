package org.example.design.javaee.callback.asynchronous;

import com.google.common.util.concurrent.FutureCallback;
import lombok.extern.log4j.Log4j2;

/**
 *  测试线程池及线程池超时功能, 十秒后超时异常处理后结束
 * Author: GL
 * Date: 2021-10-25
 */
@Log4j2
public class DemoTest {
    public static void main(String[] a) {
        CallbackThreadPoolFactory.CallbackThreadPool callbackThreadPool = CallbackThreadPoolFactory.create(5, 10);
        callbackThreadPool.addCallable(new DemoCallable(), new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                log.info(" onSuccess result = " + result);
            }
            @Override
            public void onFailure(Throwable t) {
                log.info(" onFailure Throwable t.getMessage() = " + t.getMessage());
            }
        });
    }
}
