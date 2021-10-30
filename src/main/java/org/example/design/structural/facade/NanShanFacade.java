package org.example.design.structural.facade;

/**
 * Author: GL
 * Date: 2021-10-30
 */
public class NanShanFacade implements Facade {

    private final Industry industry = new NanShanIndustry();
    private final Bank bank = new NanShanBank();
    private final Taxes taxes = new NanShanTaxes();

    @Override
    public Company registerCompany(String companyName) {
        String companyId = this.industry.register(companyName);
        String bankAccount = this.bank.openAccount(companyId);
        String taxCode = this.taxes.applyTaxCode(bankAccount);
        return new NanShanCompany(companyId, companyName, bankAccount, taxCode);
    }
}
