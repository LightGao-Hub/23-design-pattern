package org.example.design.behavioral.visitor.complete;

/**
 *  CEO访问者
 *
 * Author: GL
 * Date: 2021-11-24
 */
public class CEOVisitor implements Visitor {
    @Override
    public void visit(EngineerStaff engineerStaff) {
        System.out.println("工程师: " + engineerStaff.name + ", KPI: " + engineerStaff.kpi);
    }

    @Override
    public void visit(ManagerStaff managerStaff) {
        System.out.println("经理: " + managerStaff.name + ", KPI: " + managerStaff.kpi +
                ", 新产品数量: " + managerStaff.getProducts());
    }
}
