package org.example.design.behavioral.command.simple;

import org.example.design.behavioral.command.usually.one.Client;

/**
 * 发送放：股票发送接口
 *
 * Author: GL
 * Date: 2021-11-05
 */
public interface StockClient extends Client {
    // 此时的发送方无需持有任何引用，只需要将命令实体类传参即可！ 由于没有变量，故设计成接口
    void send(StockCommand... stockCommand);
}
