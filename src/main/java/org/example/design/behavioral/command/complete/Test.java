package org.example.design.behavioral.command.complete;

import org.example.design.behavioral.command.usually.one.StockManagerReceive;
import org.example.design.behavioral.command.usually.one.StockReceive;

/**
 *  此案例是完整版的命令模式，支持命令历史记录和撤回操作
 *
 *  实现方式：命令历史记录只需在客户端增加一个线程安全的栈集合即可实现命令记录
 *          撤回操作则需要在StockCommand接口上增加撤回函数，再由子类实现
 *
 *  结构：
 *    请求标识接口                                命令标识接口                         接收方标识接口
 *   ┌────────┐                               ┌─────────┐                         ┌─────────┐
 *   │ Client │                               │ Command │                         │ Receive │
 *   └────────┘                               └─────────┘                         └─────────┘
 *        ▲                                        ▲                                   ▲
 *        │                                        │                                   │
 *  ┌─────────────────────┐                 ┌─────────────┐                      ┌─────────────┐
 *  │StockClient          │                 │StockCommand │                      │StockReceive │ 只有StockCommand持有StockReceive引用
 *  │└Queue<StockCommand> │                 │└stockService│<---------------------│             │
 *  └─────────────────────┘                 └─────────────┘                      └─────────────┘
 *        ▲                                       ▲                                     ▲
 *        │                       ┌───────────────┼───────────────┐                     │
 * ┌────────────────┐      ┌─────────────────┐            ┌───────────────┐    ┌────────────────────┐
 * │StockUserClient │      │StockSellCommand │            │StockBuyCommand│    │StockManagerReceive │
 * └────────────────┘      └─────────────────┘            └───────────────┘    └────────────────────┘
 *
 *  总结：
 *      此案例将命令存储在队列以实现记录历史命令，注意此队列要是线程安全队列
 *
 *  缺点:
 *      目前的设计是客户端和服务端一对一，当客户端对应多个服务端的时候，则每一个命令都需要引用多个服务端，此时引用就会很复杂，解决方案是参考中介模式+命令模式[behavioral.mediator.perfect包]
 *
 * Author: GL
 * Date: 2021-11-05
 */
public class Test {
    public static void main(String[] args) {
        // 构建服务方
        StockReceive maYun = new StockManagerReceive("maYun");
        // 构建命令
        StockCommand stockBuyCommand = new StockBuyCommand(maYun);
        StockCommand stockSellCommand = new StockSellCommand(maYun);
        // 构建用户
        StockClient liJie = new StockUserClient("liJie");
        // 先买再卖，再买，再买
        liJie.send(stockBuyCommand, stockSellCommand, stockBuyCommand, stockBuyCommand);
        // 撤回最近一次购买
        liJie.undo();
        // 查看历史命令
        liJie.select();
    }
}
