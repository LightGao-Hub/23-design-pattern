package org.example.design.behavioral.memento.complete;

import org.example.design.behavioral.command.require.first.StockManagerReceive;
import org.example.design.behavioral.command.require.first.StockReceive;
import org.junit.Test;

/**
 *  此案例是命令模式 + 备忘录模式 + 一次性撤回多次功能
 *   股票案例中撤回后不可再恢复到撤回前的状态
 *
 *  结构：
 *
 *     请求标识接口                    负责人接口[存储备忘录]                 备忘录类[存储状态]      命令标识接口                   发起人接口[需要实现创建备忘录及恢复]         接收方标识接口
 *     ┌────────┐            ┌────────────────────────────────┐
 *     │ Client │            │ Caretaker                      │         ┌───────────┐       ┌─────────┐
 *     └────────┘            │  └LinkedBlockingDeque<Memento> │<--------│ Memento   │       │ Command │                 ┌───────────────────────────┐           ┌─────────┐
 *          ▲                └────────────────────────────────┘         │  └state<> │       └─────────┘                 │ Originator                │           │ Receive │
 *          │                           ▲                               └───────────┘            ▲                      │  └createMemento()         │           └─────────┘
 *    ┌──────────────┐                  │                   克隆接口 ┌─────────────────────────────│─────────────────────>│  └restoreMemento(Memento) │                ▲
 *    │StockClient   │                  │                  ┌───────────┐                  ┌─────────────┐               └───────────────────────────┘                │
 *    │└caretaker    │------------------┘                  │ Cloneable │                  │StockCommand │                                                     ┌─────────────┐
 *    └──────────────┘                                     └───────────┘                  │└stockService│<----------------------------------------------------│StockReceive │ 只有StockCommand持有StockReceive引用
 *          ▲                                                                             └─────────────┘                                                     └─────────────┘
 *          │                                                                                    ▲                                                                   ▲
 *   ┌────────────────┐                                                          ┌───────────────┼───────────────┐                                                   │
 *   │StockUserClient │                                                   ┌─────────────────┐            ┌───────────────┐                                 ┌────────────────────┐
 *   └────────────────┘                                                   │StockSellCommand │            │StockBuyCommand│                                 │StockManagerReceive │
 *                                                                        └─────────────────┘            └───────────────┘                                 └────────────────────┘
 *  总结：
 *      此案例将命令存储在队列以实现记录历史命令，注意此队列要是线程安全队列，且支持栈结构从后读取
 *
 * Author: GL
 * Date: 2021-11-05
 */
public class TestComple {
    @Test
    public void test() {
        // 构建服务方
        StockReceive maYun = new StockManagerReceive("maYun");
        // 构建命令
        StockCommand stockBuyCommand = new StockBuyCommand(maYun);
        StockCommand stockSellCommand = new StockSellCommand(maYun);
        // 构建用户
        StockClient liJie = new StockUserClient("liJie");
        // 先买再卖，再买，再买
        liJie.send(stockBuyCommand, stockSellCommand, stockBuyCommand, stockSellCommand);
        // 撤回最近一次购买
        liJie.undo();
        // 撤回最近二次购买
        liJie.undo(2);
        // 查看历史命令
        liJie.select();
    }
}
