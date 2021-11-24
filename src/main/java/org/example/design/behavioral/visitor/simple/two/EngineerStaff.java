package org.example.design.behavioral.visitor.simple.two;

import java.util.Random;

/**
 *  工程师
 *
 * Author: GL
 * Date: 2021-11-23
 */
public class EngineerStaff extends Staff {

    public EngineerStaff(String name) {
        super(name, StaffType.ENGINEER);
    }

    // 工程师一年的代码数量
    public int getCodeLines() {
        return new Random().nextInt(10 * 10000);
    }
}
