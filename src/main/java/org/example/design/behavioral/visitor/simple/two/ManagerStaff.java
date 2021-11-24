package org.example.design.behavioral.visitor.simple.two;

import java.util.Random;

/**
 *  经理
 *
 * Author: GL
 * Date: 2021-11-23
 */
public class ManagerStaff extends Staff {

    public ManagerStaff(String name) {
        super(name, StaffType.MANAGER);
    }

    // 一年做的产品数量
    public int getProducts() {
        return new Random().nextInt(10);
    }
}
