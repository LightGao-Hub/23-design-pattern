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

    private CTOStrategy(){}

    private static class CTOStrategySingle {
        /**
         * 静态初始化器, 由JVM来保证线程安全
         */
        private static final CTOStrategy INSTANCE = new CTOStrategy();
    }

    public static CTOStrategy getInstance() {
        return CTOStrategy.CTOStrategySingle.INSTANCE;
    }

    @Override
    protected void strategy(Staff staff) {
        // 通过员工类型判断进行强转后操作
        switch (staff.getStaffType()) {
            case MANAGER:
                ManagerStaff manager = (ManagerStaff) staff;
                log.info("manager: {}, Number of new products: {}", manager.getName(), manager.getProducts());
                break;
            case ENGINEER:
                EngineerStaff engineer = (EngineerStaff) staff;
                log.info("engineer: {}, Number of lines of code: {}", engineer.getName(), engineer.getCodeLines());
                break;
            default:
                throw new RuntimeException(String.format("There is no such employee type: %s", staff.getStaffType()));
        }
    }
}
