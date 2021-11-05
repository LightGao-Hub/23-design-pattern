package org.example.design.behavioral.command.usually.one;

/**
 *  接收方：股票经理人接收方
 *
 * Author: GL
 * Date: 2021-11-05
 */
public class StockManagerReceive extends StockReceive {
    // 经理人属性
    private final String name;

    @Override
    public void buy() {
        System.out.println(String.format("股票经理人-%s 已帮您购买成功", name));
    }

    @Override
    public void sell() {
        System.out.println(String.format("股票经理人-%s 已帮您抛售成功", name));
    }

    public StockManagerReceive(String name) {
        this.name = name;
    }
}
