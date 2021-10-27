package org.example.design.callback.asynchronous;

import com.google.common.util.concurrent.FutureCallback;
import org.example.design.callback.asynchronous.utils.AsynchronousCallbackUtil;
import org.example.design.callback.asynchronous.utils.AsynchronousFactory;

/**
 * Author: GL
 * Date: 2021-10-25
 */
public class MessageClient implements Client<Integer> {

    private final MessageServer server;
    // 异步调用工具类
    private final AsynchronousCallbackUtil<String> asynchronousCallbackUtil = AsynchronousFactory.create();

    public void sendMessage(Integer message) {
        System.out.println("开始进行异步消息的推送");
        // 异步调用
        asynchronousCallbackUtil.addCallable(() -> {
            server.send(message);
            return null;
        }, new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println(" onSuccess result ");
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println(" onFailure Throwable t.getMessage() = " + t.getMessage());
            }
        });
    }

    public MessageClient(MessageServer server) {
        this.server = server;
    }
}
