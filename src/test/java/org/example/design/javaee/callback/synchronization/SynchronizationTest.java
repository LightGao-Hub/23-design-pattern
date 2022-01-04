package org.example.design.javaee.callback.synchronization;

import org.junit.Test;

/**
 *  回调模式属于javaEE设计模式, 常用于客户端和服务端之间调用, 其目的是将业务模块进行解耦
 *
 *  回调的核心就是回调方将本身即this传递给调用方, 这里看messageClient.sendMessage();
 *
 *  结构：
 *           客户端                                                                               服务端
 *      ┌──────────────────────────┐
 *      │ Client                   │                                                ┌───────────────────────────────────────────────────┐
 *      │ └Server server           │───────────────────────────────────────────────>│Server                                             │
 *      │ └sendMessage(T message); │                 回调接口                         │ └receive(T message, MessageCallBack<T> callBack); │
 *      └──────────────────────────┘         ┌──────────────────────────┐           └───────────────────────────────────────────────────┘
 *                   ▲                       │ MessageCallBack          │                                    ▲
 *                   │                       │ └onSuccess(R result);    │                                    │
 *                   │                       │ └onFailure(R result);    │           ┌─────────────────────────────────────────────────────┐
 *                   │                       └──────────────────────────┘           │MessageServer                                        │
 *                   │                                    ▲                         │ └receive(T message, MessageCallBack<T> callBack){}; │
 *                   │────────────────────────────────────┘                         └─────────────────────────────────────────────────────┘
 *      ┌──────────────────────────────────────────────┐                                   ▲
 *      │ MessageClient                                │                                   │
 *      │ └sendMessage(T message){};                   │                                   │
 *      │ └onSuccess(String result){                   │                                   │
 *      │   super.getServer().receive(message, this);  │-----------------------------------┘
 *      │  };                                          │              调用
 *      │ └onFailure(String result){};                 │
 *      └──────────────────────────────────────────────┘
 *
 *
 *  总结：此案例是同步回调模式, 并非异步回调模式, 可能会有人说, 这么简单的同步机制, 我直接将MessageServer.receive()函数设置个返回值, 然后在MessageClient调用的时候判断一下返回值不就得了吗
 *  假设此函数是不需要返回值的, 而我们因为程序设计的不合理而强加给此函数返回值, 那就不符合此函数的初衷；而回调函数可以不需要此函数的返回值, 直接通过调用方的回调进行处理；
 *  所以如果是简单的函数同步可以按前者这么做, 但是如果为了解耦, 为了更好的模块分离那么我们建议使用后者回调机制.
 *  如果想用更高级的异步回调函数, 请看asynchronous包下的代码
 *
 * Author: GL
 * Date: 2021-10-25
 */
public class SynchronizationTest {
    @Test
    public void test() {
        final Client<String> messageClient = new MessageClient(new MessageServer());
        messageClient.sendMessage("This is a test message");
    }
}
