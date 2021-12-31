package org.example.design.behavioral.command.require.two;

/**
 *  接收方：股票接收方
 *
 * Author: GL
 * Date: 2021-11-05
 */
public abstract class StockReceive implements Receive {
    // 购买股票
    public abstract void buy();
    // 抛售股票
    public abstract void sell();
}
