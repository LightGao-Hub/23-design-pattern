package org.example.design.javaee.callback.asynchronous;

import java.util.Random;

/**
 *  测试异步调用，随机发送数值，server获取数值后休眠，验证异步回调
 *
 *  结构：
 *   ┌──────────────────────────┐
 *   │ Client                   │                                                                    ┌────────────┐
 *   │ └Server server           │------------------------------------------------------------------->│Server      │
 *   │ └sendMessage(T message); │                                                                    │ └receive() │
 *   └──────────────────────────┘                                                                    └────────────┘
 *        ▲                                                                                                 ▲
 *        │                                                                                                 │
 *  ┌───────────────────────────────────────────────────────────────────────┐                        ┌──────────────┐
 *  │CallbackClient                                                         │                        │MessageServer │
 *  │ └callbackPool = AsynchronousCallback.INSTANCE.getCallbackThreadPool() │──────────────────┐     │ └receive(){} │
 *  │ └sendMessage() { this.callbackPool.addCallable(                       │                  │     └──────────────┘
 *  │       send(), success(), failure() ) };                               │                  │
 *  │ └abstract send()                                                      │                  │
 *  │ └abstract success()                                                   │                  │
 *  │ └abstract failure()                                                   │                  │
 *  └───────────────────────────────────────────────────────────────────────┘                  │
 *        ▲                                                                                    │
 *        │                                                                                    │
 * ┌──────────────────────┐                                                                    │
 * │CallbackMessageClient │                                                                    │
 * │ └send(){}            │                                                                    │
 * │ └success(){}         │                                                                    │
 * │ └failure(){}         │                                                                    │
 * └──────────────────────┘                                                                    │
 *                                                                                             ▼
 *                                                                                  ┌─────────────────────────────────────────────────────────────────┐
 * ┌─────────────────────────────────────────────────────────────────────────┐      │ enum AsynchronousCallback                                       │
 * │ enum CallbackThreadPoolFactory                                          │      │ └INSTANCE                                                       │
 * │ └create() { new CallbackThreadPool }                                    │<-----│ └callbackThreadPool = CallbackThreadPoolFactory.create(10, 60); │
 * │ └create(int poolSize, int timeOut) { new CallbackThreadPool }           │      └─────────────────────────────────────────────────────────────────┘
 * │  ┌──────────────────────────────────────────────────────────────────┐   │
 * │  │static class CallbackThreadPool                                   │   │
 * │  │ └receive(){}                                                     │   │
 * │  │ └addCallable(Callable<E> call, FutureCallback<E> futureCallback) │   │
 * │  └──────────────────────────────────────────────────────────────────┘   │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * 总结：
 *      1、由于AsynchronousCallback是单例枚举，得以保障每个CallbackClient通过引用AsynchronousCallback.INSTANCE.getCallbackThreadPool()得到的都是共享一个线程池！
 *      2、又因为CallbackClient的sendMessage函数合理构建抽象，使得下游实现类无需关注回调细节，只需要实现 send(), success(), failure() 细节即可，符合开闭原则
 *      3、由于CallbackThreadPool类的创建全权交给CallbackThreadPoolFactory，则CallbackThreadPool类可以设置为静态内部类
 *
 * Author: GL
 * Date: 2021-10-25
 */
public class AsynchronousTest {
    public static void main(String[] a) {
        final Client<Integer> client = new CallbackMessageClient(new MessageServer());
        client.sendMessage(new Random().nextInt(10));
        client.sendMessage(new Random().nextInt(10));
        client.sendMessage(new Random().nextInt(10));

        // 验证两个client实际共享一个回调线程池
        final Client<Integer> client2 = new CallbackMessageClient(new MessageServer());
        client2.sendMessage(new Random().nextInt(10));
        client2.sendMessage(new Random().nextInt(10));
    }
}
