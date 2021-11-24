package org.example.design.behavioral.visitor.simple.two;

/**
 *  CEO策略类
 *
 * Author: GL
 * Date: 2021-11-23
 */
public class CEOStrategy extends CompanyStrategy {
    @Override
    protected void strategy(Staff staff) {
        // 通过员工类型判断进行强转后操作
        switch (staff.getStaffType()) {
            case MANAGER:
                ManagerStaff manager = (ManagerStaff) staff;
                System.out.println(String.format("经理: %s, KPI: %s, 新产品数量: %s", manager.getName(), manager.getKpi(), manager.getProducts()));
                break;
            case ENGINEER:
                EngineerStaff engineer = (EngineerStaff) staff;
                System.out.println(String.format("工程师: %s, KPI: %s", engineer.getName(), engineer.getKpi()));
                break;
            default:
                throw new RuntimeException(String.format("没有此员工类型: %s", staff.getStaffType()));
        }
    }
}
