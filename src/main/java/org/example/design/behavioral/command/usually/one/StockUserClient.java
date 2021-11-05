package org.example.design.behavioral.command.usually.one;

/**
 *  发送放: 用户股票发送方
 *
 * Author: GL
 * Date: 2021-11-05
 */
public class StockUserClient extends StockClient {
    // 用户自我属性
    private final String name;

    @Override
    protected void buy() {
        System.out.println(String.format("用户 %s 购买股票 ", name));
        super.buy();
    }

    @Override
    protected void sell() {
        System.out.println(String.format("用户 %s 抛售股票 ", name));
        super.sell();
    }

    public StockUserClient(StockReceive stockService, String name) {
        super(stockService);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
