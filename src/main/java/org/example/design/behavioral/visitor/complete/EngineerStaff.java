package org.example.design.behavioral.visitor.complete;

import java.util.Random;

/**
 *  工程师
 *
 * Author: GL
 * Date: 2021-11-24
 */
public class EngineerStaff extends Staff {

    public EngineerStaff(String name) {
        super(name);
    }

    // 将自己传参-利用重载[静态分派]
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    // 工程师一年的代码数量
    public int getCodeLines() {
        return new Random().nextInt(10 * 10000);
    }
}
