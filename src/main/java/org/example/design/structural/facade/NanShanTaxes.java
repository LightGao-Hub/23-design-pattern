package org.example.design.structural.facade;

/**
 *  南山纳税机构，通过公司ID获得纳税ID
 *
 * Author: GL
 * Date: 2021-10-30
 */
public class NanShanTaxes implements Taxes {
    @Override
    public String applyTaxCode(String companyId) {
        return String.valueOf(companyId.hashCode()  & Integer.MAX_VALUE);
    }
}
