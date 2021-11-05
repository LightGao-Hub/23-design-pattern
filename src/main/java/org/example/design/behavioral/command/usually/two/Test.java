package org.example.design.behavioral.command.usually.two;

import org.example.design.behavioral.command.usually.one.StockManagerReceive;

/**
 *  这里我们来解决上一个包下的问题，常用的解决思路是将请求进行单独抽象并封装，同时请求持有接收端的引用并组装逻辑，发送端只需调用请求的抽象函数即可
 *
 *  结构：
 *
 *       请求标识接口             命令标识接口              接收方标识接口        股票请求枚举类
 *      ┌────────┐             ┌─────────┐              ┌─────────┐       ┌───────────┐
 *      │ Client │             │ Command │              │ Receive │       │ StockType │
 *      └────────┘             └─────────┘              └─────────┘       └───────────┘
 *           ▲                      ▲                       ▲
 *           │                      │                       │
 *     ┌──────────────┐       ┌─────────────┐         ┌─────────────┐
 *     │StockClient   │       │StockCommand │         │StockReceive │
 *     │└stockCommand │<------│└stockService│<------- │             │ StockCommand持有StockReceive引用进行操作，而StockClient则持有StockCommand引用操作；
 *     └──────────────┘       └─────────────┘         └─────────────┘
 *           ▲                                              ▲
 *           │                                              │
 *    ┌────────────────┐                            ┌────────────────────┐
 *    │StockUserClient │                            │StockManagerReceive │
 *    └────────────────┘                            └────────────────────┘
 *
 *
 *  总结：通过抽象请求为StockCommand类，将请求方和接收方进行解耦，如果后续接收方新增函数，则只需更改StockCommand类中的execute函数即可
 *
 *  缺点：虽然将请求方和接收方进行解耦，但是依然不符合设计模式的开闭原则，即当接收方新增函数后，依旧要改变StockCommand类中的execute函数
 *
 *  解决：参考simple包下的Test类
 *
 * Author: GL
 * Date: 2021-11-05
 */
public class Test {
    public static void main(String[] args) {
        // 构建请求类
        StockCommand stockCommand = new StockCommand(new StockManagerReceive("maYun"));
        // 构建用户请求类
        StockClient stockClient = new StockUserClient(stockCommand, "liJie");
        // 发送请求
        stockClient.send(StockType.BUY);
        stockClient.send(StockType.SELL);
    }
}
