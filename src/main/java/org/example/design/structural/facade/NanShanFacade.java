package org.example.design.structural.facade;

/**
 * Author: GL
 * Date: 2021-10-30
 */
public class NanShanFacade implements Facade {

    @Override
    public Company registerCompany(String companyName) {
        String companyId = new NanShanIndustry().register(companyName);
        String bankAccount = new NanShanBank().openAccount(companyId);
        String taxCode = new NanShanTaxes().applyTaxCode(bankAccount);
        return new NanShanCompany(companyId, companyName, bankAccount, taxCode);
    }
}
