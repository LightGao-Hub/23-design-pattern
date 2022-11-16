package org.example.design.behavioral.visitor.require.second;

import lombok.extern.log4j.Log4j2;

/**
 *  CEO策略类
 *
 * Author: GL
 * Date: 2021-11-23
 */
@Log4j2
public class CEOStrategy extends CompanyStrategy {

    private CEOStrategy(){}

    private static class CEOStrategySingle {
        private static final CEOStrategy INSTANCE = new CEOStrategy();
    }

    public static CEOStrategy getInstance() {
        return CEOStrategy.CEOStrategySingle.INSTANCE;
    }

    @Override
    protected void strategy(Staff staff) {
        // 通过员工类型判断进行强转后操作
        switch (staff.getStaffType()) {
            case MANAGER:
                ManagerStaff manager = (ManagerStaff) staff;
                log.info(String.format("manager: %s, KPI: %s, Number of new products: %s", manager.getName(), manager.getKpi(),
                        manager.getProducts()));
                break;
            case ENGINEER:
                EngineerStaff engineer = (EngineerStaff) staff;
                log.info(String.format("engineer: %s, KPI: %s", engineer.getName(), engineer.getKpi()));
                break;
            default:
                throw new RuntimeException(String.format("There is no such employee type: %s", staff.getStaffType()));
        }
    }

}
