package org.example.design.behavioral.visitor.complete;

import java.util.Random;

/**
 *  经理
 *
 * Author: GL
 * Date: 2021-11-24
 */
public class ManagerStaff extends Staff {

    public ManagerStaff(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    // 一年做的产品数量
    public int getProducts() {
        return new Random().nextInt(10);
    }
}
