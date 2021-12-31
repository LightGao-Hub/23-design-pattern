package org.example.design.behavioral.state;

import lombok.Getter;
import lombok.Setter;
import org.example.design.behavioral.command.require.two.Client;

/**
 *  股票客户端父类，持有stockState引用！ 这也是和命令模式最大的区别！命令模式的客户端是不保存状态的，每次请求只需要根据command调用execute即可
 *      但状态模式中必须要有状态才可以发送请求！并且可以连续发送同一状态的请求
 *
 * Author: GL
 * Date: 2021-11-19
 */
public abstract class StockClient implements Client {
    @Getter
    @Setter
    private StockState stockState;

    protected StockClient(StockState stockState) {
        this.stockState = stockState;
    }

    public abstract void send();

}
