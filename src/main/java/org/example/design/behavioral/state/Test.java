package org.example.design.behavioral.state;

import org.example.design.behavioral.command.require.first.StockManagerReceive;
import org.example.design.behavioral.command.require.first.StockReceive;

/**
 *  此案例为状态模式：状态模式允许一个对象在其内部状态改变的时候改变其行为。这个对象看上去就像是改变了它的类一样。
 *
 *  状态模式和命令模式很相似，其思想有异曲同工之妙，但本质上却有所不同，还记得命令模式的时候，client -> receive 时将请求封装进了command中，由不同的command来执行对应操作
 *
 *  而在状态模式中，将command变成了state! client 内部持有一个state [重点！]， 每次client发送请求的时候都是由持有的state状态内部来执行相应的逻辑！
 *
 *  结构：
 *
 *        客户端[持有状态]                          状态[持有服务端]                           服务端
 *        ┌────────┐
 *        │ Client │                               ┌───────┐                           ┌─────────┐
 *        └────────┘                               │ State │                           │ Receive │
 *             ▲                                   └───────┘                           └─────────┘
 *             │                                        ▲                                   ▲
 *       ┌──────────────┐                               │                                   │
 *       │StockClient   │                        ┌─────────────┐                      ┌─────────────┐  只有
 *       │ └stockState  │<-----------------------│StockState   │                      │StockReceive │
 *       └──────────────┘                        │└stockService│<---------------------│             │
 *             ▲                                 └─────────────┘                      └─────────────┘
 *             │                                       ▲                                     ▲
 *      ┌────────────────┐             ┌───────────────┼───────────────┐                     │
 *      │StockUserClient │      ┌───────────────┐                ┌─────────────┐   ┌────────────────────┐
 *      └────────────────┘      │StockSellState │                │StockBuyState│   │StockManagerReceive │
 *                              └───────────────┘                └─────────────┘   └────────────────────┘
 *  总结：
 *
 *      状态模式：内部维护一个状态，会随着public setState的调用进行相应的状态转移。外界不需要知道状态及其变化情况。
 *
 *      命令模式：根据客户的请求封装相应的命令，处理者就不用care这个命令是什么，该怎么处理。只用去调用Command统一的execute接口即可。
 *
 * Author: GL
 * Date: 2021-11-19
 */
public class Test {
    public static void main(String[] args) {
        // 构建服务方
        StockReceive maYun = new StockManagerReceive("maYun");
        // 构建服务方，并且设置状态为购买
        StockClient stockClient = new StockUserClient(new StockBuyState(maYun));
        // 购买三次！这里就和命令模式区分了，状态是根据内部持有的状态进行请求，而命令模式则是每次请求根据命令类！并不持有状态
        stockClient.send();
        stockClient.send();
        stockClient.send();
        // 设置卖出状态
        stockClient.setStockState(new StockSellState(maYun));
        // 卖出三次
        stockClient.send();
        stockClient.send();
        stockClient.send();
    }
}
