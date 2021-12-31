package org.example.design.behavioral.command.complete;

import org.example.design.behavioral.command.require.two.StockManagerReceive;
import org.example.design.behavioral.command.require.two.StockReceive;
import org.junit.Test;

/**
 *  此案例是完整版的命令模式，支持命令历史记录和撤回操作
 *
 *  实现方式：命令历史记录只需在客户端增加一个线程安全的栈集合即可实现命令记录
 *          撤回操作则需要在StockCommand接口上增加撤回函数，再由子类实现
 *
 *  结构：
 *    请求标识接口                                命令标识接口                         接收方标识接口
 *   ┌────────┐
 *   │ Client │                               ┌─────────┐                         ┌─────────┐
 *   └────────┘                               │ Command │                         │ Receive │
 *        ▲                                   └─────────┘                         └─────────┘
 *        │                                        ▲                                   ▲
 *  ┌─────────────────────┐                        │                                   │
 *  │StockClient          │                 ┌─────────────┐                            │
 *  │└Queue<StockCommand> │<----------------│StockCommand │                      ┌─────────────┐
 *  └─────────────────────┘                 │└stockService│<---------------------│StockReceive │ 只有StockCommand持有StockReceive引用
 *        ▲                                 └─────────────┘                      └─────────────┘
 *        │                                       ▲                                     ▲
 * ┌────────────────┐             ┌───────────────┼───────────────┐                     │
 * │StockUserClient │      ┌─────────────────┐            ┌───────────────┐    ┌────────────────────┐
 * └────────────────┘      │StockSellCommand │            │StockBuyCommand│    │StockManagerReceive │
 *                         └─────────────────┘            └───────────────┘    └────────────────────┘
 *  总结：
 *      此案例将命令存储在队列以实现记录历史命令，注意此队列要是线程安全队列，且支持栈结构从后读取
 *
 *  缺点:
 *
 *      1、此案例中客户端与服务度并不需要传递参数，假设客户端与服务端需要传递参数，则每次send都需要创建一个新的Command，解决方案：使用状态模式[behavioral.state]，在client客户端中保存状态
 *          而状态中持有服务端引用和请求逻辑即可，注意线程安全问题；
 *
 *      2、目前的设计是客户端和服务端一对一，当客户端对应多个服务端的时候，则每一个命令类内部都需要引用多个服务端[股票经理人A, 股票经理人B, 股票经理人C]，
 *          此时命令实现类中的引用就会很复杂[可能一个buy命令实现类需要引用A,B两个股票经理人]，解决方案是：状态模式 + 简单版中介者模式[behavioral.mediator.simple]
 *
 *      3、注意：命令模式中的记录历史命令是有缺陷的，此模式的记录命令并不是快照方式，而是将原有的引用放进队列，此时如果命令内部属性修改，则队列中的元素也会修改，并不会起到快照作用，所以此处有漏洞。
 *         解决：参考备忘录模式[behavioral.memento.complete]
 *
 *      3、撤销不支持一次性撤销多条功能，此处在备忘录模式下完善[behavioral.memento.complete]
 *
 * Author: GL
 * Date: 2021-11-05
 */
public class TestComplete {
    @Test
    public void test() {
        // 构建服务方
        StockReceive maYun = new StockManagerReceive("maYun");
        // 构建命令
        StockCommand stockBuyCommand = new StockBuyCommand(maYun);
        StockCommand stockSellCommand = new StockSellCommand(maYun);
        // 构建用户
        StockClient liJie = new StockUserClient("liJie");
        // 先买再卖，再买，再卖
        liJie.send(stockBuyCommand, stockSellCommand, stockBuyCommand, stockSellCommand);
        // 撤回最近一次
        liJie.undo();
        // 再次撤回最近一次
        liJie.undo();
        // 查看历史命令
        liJie.select();
    }
}
