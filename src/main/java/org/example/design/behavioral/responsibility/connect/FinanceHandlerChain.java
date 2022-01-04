package org.example.design.behavioral.responsibility.connect;

import java.util.Objects;

import lombok.extern.log4j.Log4j2;
import org.example.design.behavioral.responsibility.separate.FinanceRequest;
import org.example.design.behavioral.responsibility.separate.ResponsibilityChain;

/**
 *  责任链抽象父类
 *
 * Author: GL
 * Date: 2021-11-02
 */
@Log4j2
public abstract class FinanceHandlerChain implements ResponsibilityChain, MessageCallBack<FinanceRequest> {

    // 持有后继的责任对象
    private FinanceHandlerChain handler;

    // 示意处理请求的方法
    public abstract void process(FinanceRequest financeRequest);

    public void setSuccessor(FinanceHandlerChain handler) {
        this.handler = handler;
    }

    // 回调函数
    @Override
    public void onSuccess(FinanceRequest result) {
        if (Objects.nonNull(result) && Objects.nonNull(this.handler)) {
            this.handler.process(result);
        } else {
            this.onFailure(result);
        }
    }

    @Override
    public void onFailure(FinanceRequest result) {
        log.info("No higher authority, approval failed");
    }

}
