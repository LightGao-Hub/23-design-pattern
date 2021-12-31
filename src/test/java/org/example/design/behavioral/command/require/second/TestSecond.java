package org.example.design.behavioral.command.require.second;

import org.example.design.behavioral.command.require.first.StockManagerReceive;
import org.junit.Test;

/**
 *  这里我们来解决上一个包下的问题，常用的解决思路是将请求进行单独抽象并封装，同时请求持有接收端的引用并组装逻辑，发送端只需调用请求的抽象函数即可
 *      此实现本质上是一个中介者模式，详细可看[mediator包]
 *
 *  结构：
 *
 *       请求标识接口             命令标识接口              接收方标识接口        股票请求枚举类
 *      ┌────────┐             ┌─────────┐              ┌─────────┐       ┌───────────┐
 *      │ Client │             │ Command │              │ Receive │       │ StockType │
 *      └────────┘             └─────────┘              └─────────┘       └───────────┘
 *           ▲                      ▲                       ▲
 *           │                      │                       │
 *     ┌──────────────┐       ┌─────────────┐               │
 *     │StockClient   │       │StockCommand │         ┌─────────────┐
 *     │└stockCommand │<------│└stockService│<------- │StockReceive │ StockCommand持有StockReceive引用进行操作，而StockClient则持有StockCommand引用操作；
 *     └──────────────┘       └─────────────┘         └─────────────┘
 *           ▲                      ▲                       ▲
 *           │                      │                       │
 *    ┌────────────────┐    ┌───────────────────┐  ┌────────────────────┐
 *    │StockUserClient │    │StockClientCommand │  │StockManagerReceive │
 *    └────────────────┘    └───────────────────┘  └────────────────────┘
 *
 *
 *  总结：通过抽象请求为StockCommand类，将请求方和接收方进行解耦，如果后续接收方新增函数，则只需新增StockCommand子类并实现新的execute函数即可
 *
 *  缺点：虽然将请求方和接收方进行解耦，但设计依然不合理，因其send函数需要通过StockType枚举类型进行判断才可执行响应函数，并未将各个模块完全拆分；
 *
 *  解决：参考simple包
 *
 * Author: GL
 * Date: 2021-11-05
 */
public class TestSecond {
    @Test
    public void test() {
        // 构建请求类
        StockCommand stockCommand = new StockClientCommand(new StockManagerReceive("maYun"));
        // 构建用户请求类
        StockClient stockClient = new StockUserClient(stockCommand, "liJie");
        // 发送请求
        stockClient.send(StockType.BUY);
        stockClient.send(StockType.SELL);
    }
}
