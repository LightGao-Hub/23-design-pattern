package org.example.design.behavioral.visitor.complete;

import java.util.LinkedList;
import java.util.List;

import lombok.Getter;

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
     * 根据访问者展示报表
     * @param visitor 公司高层, 如CEO、CTO
     */
    public abstract void showReport(Visitor visitor);
}
