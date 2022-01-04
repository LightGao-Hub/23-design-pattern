package org.example.design.behavioral.responsibility.connect;

import static org.example.design.config.FinalConfig.DIRECTOR_RULE;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;
import org.example.design.behavioral.responsibility.separate.FinanceRequest;

/**
 *  主任处理
 *
 * Author: GL
 * Date: 2021-11-02
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Log4j2
public class DirectorFinanceHandler extends FinanceHandlerChain {
    // 审批人
    private String name;
    // 可审批金额
    private BigDecimal amount;

    public DirectorFinanceHandler(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }

    // 主任自己的处理逻辑, 如果请求人为前台则无论金额都会审批通过, 你懂得
    @Override
    public void process(FinanceRequest financeRequest) {
        assert financeRequest != null;
        if (financeRequest.getAmount().compareTo(this.amount) <= 0 || DIRECTOR_RULE.equalsIgnoreCase(financeRequest.getName())) {
            log.info(String.format(" %s Approved ", this.name));
        } else {
            super.onSuccess(financeRequest);
        }
    }
}
