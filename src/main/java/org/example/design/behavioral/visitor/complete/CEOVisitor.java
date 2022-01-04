package org.example.design.behavioral.visitor.complete;

import lombok.extern.log4j.Log4j2;

/**
 * CEO访问者
 * <p>
 * Author: GL
 * Date: 2021-11-24
 */
@Log4j2
public class CEOVisitor implements Visitor {
    @Override
    public void visit(EngineerStaff engineerStaff) {
        log.info(String.format("engineer: %s, KPI: %s", engineerStaff.getName(), engineerStaff.getKpi()));
    }

    @Override
    public void visit(ManagerStaff managerStaff) {
        log.info(String.format("manager: %s, KPI: %s, Number of new products: %s", managerStaff.getName(), managerStaff.getKpi(),
                managerStaff.getProducts()));
    }
}
