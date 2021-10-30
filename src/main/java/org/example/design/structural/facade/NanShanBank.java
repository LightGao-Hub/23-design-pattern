package org.example.design.structural.facade;

/**
 *  南山银行，根据企业Id开账户
 *
 * Author: GL
 * Date: 2021-10-30
 */
public class NanShanBank implements Bank {
    @Override
    public String openAccount(String companyId) {
        return String.valueOf(companyId.hashCode() & Integer.MAX_VALUE);
    }
}
