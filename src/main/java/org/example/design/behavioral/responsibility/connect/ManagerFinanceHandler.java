package org.example.design.behavioral.responsibility.connect;

import lombok.Data;
import org.example.design.behavioral.responsibility.separate.FinanceRequest;

import java.math.BigDecimal;

/**
 *  leader处理
 *
 * Author: GL
 * Date: 2021-11-02
 */
@Data
public class ManagerFinanceHandler extends FinanceHandlerChain {
    // 审批人
    private String name;
    // 可审批金额
    private BigDecimal amount;

    public ManagerFinanceHandler(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }

    // leader自己的处理逻辑
    @Override
    public void handleRequest(FinanceRequest financeRequest) {
        assert financeRequest != null;
        if (financeRequest.getAmount().compareTo(this.amount) <= 0) {
            System.out.println(String.format(" %s 审批通过 ", this.name));
        } else {
            super.onSuccess(financeRequest);
        }
    }
}
