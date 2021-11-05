package org.example.design.behavioral.command.usually.two;

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
    public void send(StockType stockType) {
        System.out.println(String.format("用户 %s 发送请求 %s ", name, stockType));
        super.getStockCommand().execute(stockType);
    }

    public StockUserClient(StockCommand stockCommand, String name) {
        super(stockCommand);
        this.name = name;
    }
}
