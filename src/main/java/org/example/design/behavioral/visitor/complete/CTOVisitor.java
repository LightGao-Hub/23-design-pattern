package org.example.design.behavioral.visitor.complete;

import lombok.extern.log4j.Log4j2;

/**
 *  CEO访问者
 *
 * Author: GL
 * Date: 2021-11-24
 */
@Log4j2
public class CTOVisitor implements Visitor {

    private CTOVisitor(){}

    private static class CTOVisitorSingle {
        private static final CTOVisitor INSTANCE = new CTOVisitor();
    }

    public static CTOVisitor getInstance() {
        return CTOVisitor.CTOVisitorSingle.INSTANCE;
    }

    @Override
    public void visit(EngineerStaff engineerStaff) {
        log.info(String.format("engineer: %s, Number of lines of code: %s", engineerStaff.getName(), engineerStaff.getCodeLines()));
    }

    @Override
    public void visit(ManagerStaff managerStaff) {
        log.info(String.format("manager: %s, Number of new products: %s", managerStaff.getName(), managerStaff.getProducts()));
    }
}
