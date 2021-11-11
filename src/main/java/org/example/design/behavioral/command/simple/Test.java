package org.example.design.behavioral.command.simple;

import org.example.design.behavioral.command.usually.one.StockManagerReceive;
import org.example.design.behavioral.command.usually.one.StockReceive;

/**
 *  此案例为正常的命令设计模式，用于解决usually包下弊端。
 *
 *  设计思路：每一个命令都是一个实体！命令模式的核心是把发出命令的客户端和执行命令的接收方 分隔开，委派给不同的命令的对象处理！
 *
 *  结构：
 *
 *    请求标识接口                                命令标识接口                         接收方标识接口
 *    ┌────────┐                               ┌─────────┐                         ┌─────────┐
 *    │ Client │                               │ Command │                         │ Receive │
 *    └────────┘                               └─────────┘                         └─────────┘
 *         ▲                                        ▲                                   ▲
 *         │                                        │                                   │
 *   ┌──────────────┐                        ┌─────────────┐                      ┌─────────────┐
 *   │StockClient   │                        │StockCommand │                      │StockReceive │   只有StockCommand持有StockReceive引用
 *   │              │                        │└stockService│<---------------------│             │
 *   └──────────────┘                        └─────────────┘                      └─────────────┘
 *         ▲                                       ▲                                     ▲
 *         │                       ┌───────────────┼───────────────┐                     │
 *  ┌────────────────┐      ┌─────────────────┐            ┌───────────────┐    ┌────────────────────┐
 *  │StockUserClient │      │StockSellCommand │            │StockBuyCommand│    │StockManagerReceive │
 *  └────────────────┘      └─────────────────┘            └───────────────┘    └────────────────────┘
 *
 *  总结：请求方不在引用任何变量！而是单纯的接受命令实现类，来进行请求访问接收方！
 *
 *  优点：通过将命令设计成不同命令类，将每一个命令抽象，让发送方和接收方都无需了解彼此，彻底将双方解耦，并且实现了开闭原则
 *       如接收方增加一个函数，那么只需要创建一个新的StockCommand类即可！其他类无需改动；
 *
 *  不足：
 *      1、当遇到复杂的命令场景时，我们应该具有历史任务的一个备份和撤回操作！ 可以参考complete包下的Test
 *      2、目前的设计是客户端和服务端一对一，当客户端对应多个服务端的时候，则每一个命令都需要引用多个服务端，此时引用就会很复杂，解决方案是参考中介模式+命令模式[behavioral.mediator.perfect包]
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
        // 构建请求方
        StockUserClient liJie = new StockUserClient("liJie");
        // 发送请求
        liJie.send(stockBuyCommand, stockSellCommand);
    }
}
