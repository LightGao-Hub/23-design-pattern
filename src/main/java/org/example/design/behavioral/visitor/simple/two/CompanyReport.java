package org.example.design.behavioral.visitor.simple.two;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

/**
 *  报表父类
 *
 * Author: GL
 * Date: 2021-11-23
 */
public abstract class CompanyReport {

    @Getter
    private final List<Staff> mStaffs = new LinkedList<>();

    /**
     * 根据策略展示报表
     * @param companyStrategy 公司高层，如CEO、CTO
     */
    public abstract void showReport(CompanyStrategy companyStrategy);
}
