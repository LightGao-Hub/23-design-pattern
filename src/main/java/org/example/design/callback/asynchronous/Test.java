package org.example.design.callback.asynchronous;

import java.util.Random;

/**
 *  测试异步调用，随机发送数值，server获取数值后休眠，验证异步回调
 * Author: GL
 * Date: 2021-10-25
 */
public class Test {
    public static void main(String[] args) {
        final MessageClient messageClient = new MessageClient(new MessageServer());
        messageClient.sendMessage(new Random().nextInt(10));
        messageClient.sendMessage(new Random().nextInt(10));
        messageClient.sendMessage(new Random().nextInt(10));
    }
}
