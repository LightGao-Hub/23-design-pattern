package org.example.design.behavioral.responsibility.separate;

import lombok.Data;

import java.math.BigDecimal;

/**
 *  公司财务请求
 *
 * Author: GL
 * Date: 2021-10-31
 */
@Data
public class FinanceRequest implements Request {

    private String name;
    private BigDecimal amount;

    public FinanceRequest(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }

}
