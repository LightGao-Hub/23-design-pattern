package org.example.design.behavioral.command.require.first;

import org.junit.Test;

/**
 *  这里举例一个没有使用命令模式，常用的请求和接受操作的设计：
 *
 *      现在模拟一个用户向股票经理人服务器发送请求的场景：
 *
 *      用户可以向股票经理人服务器发送：1、购买股票  2、抛售股票
 *
 *      结构如下：
 *
 *        请求标识接口              接收方标识接口
 *        ┌────────┐              ┌─────────┐
 *        │ Client │              │ Receive │
 *        └────────┘              └─────────┘
 *             ▲                       ▲
 *             │                       │
 *       ┌─────────────┐               │
 *       │StockClient  │         ┌─────────────┐
 *       │└stockService│<--------│StockReceive │  StockClient持有StockReceive引用
 *       └─────────────┘         └─────────────┘
 *             ▲                       ▲
 *             │                       │
 *      ┌────────────────┐    ┌────────────────────┐
 *      │StockUserClient │    │StockManagerReceive │
 *      └────────────────┘    └────────────────────┘
 *
 *  总结：传统的发送和接受场景里，客户端会持有服务端的引用，然后会根据服务端的函数进而封装请求端的函数
 *
 *  弊端：客户端必须对服务端的函数有所了解，才能构建客户端的函数体，不仅如此，更重要的是增加了后面维护的成本，假如StockReceive新增函数，那么客户端也要进行修改，不符合开闭原则！
 *
 *  解决：参考second包
 *
 * Author: GL
 * Date: 2021-11-05
 */
public class TestFirst {
    @Test
    public void test() {
        StockClient stockClient = new StockUserClient(new StockManagerReceive("maYun"), "liJie");
        stockClient.buy();
        stockClient.sell();
    }
}
