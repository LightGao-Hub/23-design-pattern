package org.example.design.behavioral.visitor.require.second;

import lombok.extern.log4j.Log4j2;

/**
 *  CTO策略类
 *
 * Author: GL
 * Date: 2021-11-23
 */
@Log4j2
public class CTOStrategy extends CompanyStrategy {
    @Override
    protected void strategy(Staff staff) {
        // 通过员工类型判断进行强转后操作
        switch (staff.getStaffType()) {
            case MANAGER:
                ManagerStaff manager = (ManagerStaff) staff;
                log.info(String.format("manager: %s, Number of new products: %s", manager.getName(), manager.getProducts()));
                break;
            case ENGINEER:
                EngineerStaff engineer = (EngineerStaff) staff;
                log.info(String.format("engineer: %s, Number of lines of code: %s", engineer.getName(), engineer.getCodeLines()));
                break;
            default:
                throw new RuntimeException(String.format("There is no such employee type: %s", staff.getStaffType()));
        }
    }
}
