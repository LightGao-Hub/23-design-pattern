package org.example.design.behavioral.visitor.complete;

/**
 *  CEO访问者
 *
 * Author: GL
 * Date: 2021-11-24
 */
public class CTOVisitor implements Visitor {
    @Override
    public void visit(EngineerStaff engineerStaff) {
        System.out.println("工程师: " + engineerStaff.name + ", 代码行数: " + engineerStaff.getCodeLines());
    }

    @Override
    public void visit(ManagerStaff managerStaff) {
        System.out.println("经理: " + managerStaff.name + ", 产品数量: " + managerStaff.getProducts());
    }
}
