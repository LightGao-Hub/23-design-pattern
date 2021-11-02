package org.example.design.behavioral.responsibility.connect;

import org.example.design.behavioral.responsibility.separate.FinanceRequest;
import org.example.design.behavioral.responsibility.separate.ResponsibilityChain;

/**
 *  责任链抽象父类
 *
 * Author: GL
 * Date: 2021-11-02
 */
public abstract class FinanceHandlerChain implements ResponsibilityChain, MessageCallBack<FinanceRequest> {

    // 持有后继的责任对象
    private FinanceHandlerChain handler;

    // 示意处理请求的方法，可参可不参看设计
    public abstract void handleRequest(FinanceRequest financeRequest);

    public void setSuccessor(FinanceHandlerChain handler) {
        this.handler = handler;
    }

    // 回调函数
    @Override
    public void onSuccess(FinanceRequest result) {
        assert result != null;
        if (this.handler != null) {
            this.handler.handleRequest(result);
        } else {
            this.onFailure(result);
        }
    }

    @Override
    public void onFailure(FinanceRequest result) {
        System.out.println("暂无更高权限，审批失败");
    }

}
