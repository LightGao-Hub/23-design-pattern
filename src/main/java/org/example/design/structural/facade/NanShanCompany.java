package org.example.design.structural.facade;


import lombok.Data;

/**
 *  科技公司：需要有公司名称，工商ID，银行账户ID，纳税机关ID。且只对外提供get函数，不提供set修改属性。
 *
 * Author: GL
 * Date: 2021-10-30
 */
@Data
public class NanShanCompany implements Company {

    private String id;
    private String name;
    private String bankAccount;
    private String taxCode;

    public NanShanCompany(String id, String name, String bankAccount, String taxCode) {
        this.id = id;
        this.name = name;
        this.bankAccount = bankAccount;
        this.taxCode = taxCode;
    }
}
