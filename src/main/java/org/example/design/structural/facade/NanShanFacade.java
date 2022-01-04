package org.example.design.structural.facade;

/**
 *  枚举单例类
 *   外观类
 *
 * Author: GL
 * Date: 2021-10-30
 */
public enum NanShanFacade implements Facade {
    INSTANCE;

    @Override
    public Company registerCompany(String companyName) {
        String companyId = NanShanIndustry.INSTANCE.register(companyName);
        String bankAccount = NanShanBank.INSTANCE.openAccount(companyId);
        String taxCode = NanShanTaxes.INSTANCE.applyTaxCode(bankAccount);
        return new NanShanCompany(companyId, companyName, bankAccount, taxCode);
    }
}
