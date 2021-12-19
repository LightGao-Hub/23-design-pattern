package org.example.design.javaee.callback.asynchronous;

import com.google.common.util.concurrent.FutureCallback;
import lombok.Getter;

/**
 *  可回调客户端父类：
 *      使用桥接模式引用AsynchronousCallback回调线程类
 *      使用模板模式, 定义发送模板
 *
 * Author: GL
 * Date: 2021-10-25
 */
public abstract class CallbackClient<T> extends Client<T> {
    @Getter
    private final CallbackThreadPoolFactory.CallbackThreadPool callbackPool =
            AsynchronousCallback.INSTANCE.getCallbackThreadPool();

    protected CallbackClient(Server<T> server) {
        super(server);
    }

    protected abstract T send(T message);

    protected abstract void success(T result);

    protected abstract void failure(Throwable t);

    // 模板模式
    public void sendMessage(T message) {
        this.callbackPool.addCallable(() -> send(message), new FutureCallback<T>() {
            @Override
            public void onSuccess(T result) {
                success(result);
            }
            @Override
            public void onFailure(Throwable t) {
                failure(t);
            }
        });
    }

}
