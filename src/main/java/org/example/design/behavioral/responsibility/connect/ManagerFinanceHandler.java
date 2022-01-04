package org.example.design.behavioral.responsibility.connect;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;
import org.example.design.behavioral.responsibility.separate.FinanceRequest;

/**
 *  leader处理
 *
 * Author: GL
 * Date: 2021-11-02
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Log4j2
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
    public void process(FinanceRequest financeRequest) {
        assert financeRequest != null;
        if (financeRequest.getAmount().compareTo(this.amount) <= 0) {
            log.info(String.format(" %s Approved ", this.name));
        } else {
            super.onSuccess(financeRequest);
        }
    }
}
