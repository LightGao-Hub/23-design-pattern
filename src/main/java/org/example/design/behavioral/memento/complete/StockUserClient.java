package org.example.design.behavioral.memento.complete;

import lombok.extern.log4j.Log4j2;

/**
 * 发送放: 用户股票发送方
 * <p>
 * Author: GL
 * Date: 2021-11-05
 */
@Log4j2
public class StockUserClient extends StockClient {

    // 用户自我属性
    private final String name;

    // 记录命令及请求操作
    @Override
    public void send(StockCommand... stockCommand) {
        log.info(String.format("StockUserClient name:%s send ... ", name));
        for (StockCommand command : stockCommand) {
            super.getCaretaker().saveMemento(command.createMemento());
            command.execute();
        }
    }

    public StockUserClient(String name) {
        this.name = name;
    }
}
