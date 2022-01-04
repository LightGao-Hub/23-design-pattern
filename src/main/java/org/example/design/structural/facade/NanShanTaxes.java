package org.example.design.structural.facade;

/**
 * 枚举单例类
 *  南山纳税机构, 通过公司ID获得纳税ID
 *
 * Author: GL
 * Date: 2021-10-30
 */
public enum NanShanTaxes implements Taxes {
    INSTANCE;

    @Override
    public String applyTaxCode(String companyId) {
        return String.valueOf(companyId.hashCode()  & Integer.MAX_VALUE);
    }
}
