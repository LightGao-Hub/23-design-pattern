package org.example.design.structural.facade;

/**
 * 枚举单例类
 *  南山银行, 根据企业Id开账户
 *
 * Author: GL
 * Date: 2021-10-30
 */
public enum NanShanBank implements Bank {
    INSTANCE;

    @Override
    public String openAccount(String companyId) {
        return String.valueOf(companyId.hashCode() & Integer.MAX_VALUE);
    }
}
