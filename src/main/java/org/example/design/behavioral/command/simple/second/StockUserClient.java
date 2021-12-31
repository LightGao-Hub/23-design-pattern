package org.example.design.behavioral.command.simple.second;

/**
 *  发送放: 用户股票发送方
 *
 * Author: GL
 * Date: 2021-11-05
 */
public class StockUserClient implements StockClient {

    // 用户自我属性
    private final String name;

    @Override
    public void send(StockCommand... stockCommand) {
        System.out.println(String.format("用户 %s 操作股票 ", name));
        for (StockCommand command : stockCommand) {
            command.execute();
        }
    }

    public StockUserClient(String name) {
        this.name = name;
    }

}
