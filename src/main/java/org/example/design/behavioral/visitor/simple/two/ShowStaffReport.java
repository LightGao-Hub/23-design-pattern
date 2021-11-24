package org.example.design.behavioral.visitor.simple.two;

/**
 *  员工报表类
 *
 * Author: GL
 * Date: 2021-11-23
 */
public class ShowStaffReport extends CompanyReport {

    {
        super.getMStaffs().add(new ManagerStaff("经理-A"));
        super.getMStaffs().add(new EngineerStaff("工程师-A"));
        super.getMStaffs().add(new EngineerStaff("工程师-B"));
        super.getMStaffs().add(new EngineerStaff("工程师-C"));
        super.getMStaffs().add(new ManagerStaff("经理-B"));
        super.getMStaffs().add(new EngineerStaff("工程师-D"));
    }

    // 根据策略实现员工报表
    public void showReport(CompanyStrategy companyStrategy) {
        for (Staff staff : super.getMStaffs()) {
            companyStrategy.strategy(staff);
        }
    }
}
