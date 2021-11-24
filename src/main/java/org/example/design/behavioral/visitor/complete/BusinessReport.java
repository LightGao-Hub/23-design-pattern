package org.example.design.behavioral.visitor.complete;


/**
 *  员工业务报表类
 *
 * Author: GL
 * Date: 2021-11-24
 */
public class BusinessReport extends CompanyReport {
    // 构建
    {
        super.getMStaffs().add(new ManagerStaff("经理-A"));
        super.getMStaffs().add(new EngineerStaff("工程师-A"));
        super.getMStaffs().add(new EngineerStaff("工程师-B"));
        super.getMStaffs().add(new EngineerStaff("工程师-C"));
        super.getMStaffs().add(new ManagerStaff("经理-B"));
        super.getMStaffs().add(new EngineerStaff("工程师-D"));
    }

    // 为访问者展示报表
    @Override
    public void showReport(Visitor visitor) {
        for (Staff staff : super.getMStaffs()) {
            staff.accept(visitor);
        }
    }
}
