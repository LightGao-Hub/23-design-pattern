package org.example.design.behavioral.responsibility.connect;

import lombok.Data;
import org.example.design.behavioral.responsibility.separate.FinanceRequest;

import java.math.BigDecimal;

/**
 *  主任处理
 *
 * Author: GL
 * Date: 2021-11-02
 */
@Data
public class DirectorFinanceHandler extends FinanceHandlerChain {
    // 审批人
    private String name;
    // 可审批金额
    private BigDecimal amount;

    public DirectorFinanceHandler(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }

    // 主任自己的处理逻辑, 如果请求人为前台则无论金额都会审批通过
    @Override
    public void handleRequest(FinanceRequest financeRequest) {
        assert financeRequest != null;
        if (financeRequest.getAmount().compareTo(this.amount) <= 0 || "前台".equalsIgnoreCase(financeRequest.getName())) {
            System.out.println(String.format(" %s 审批通过 ", this.name));
        } else {
            super.onSuccess(financeRequest);
        }
    }
}
