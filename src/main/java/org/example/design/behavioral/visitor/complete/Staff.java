package org.example.design.behavioral.visitor.complete;

import java.util.Random;

/**
 *  员工基类
 *
 * Author: GL
 * Date: 2021-11-24
 */
public abstract class Staff {

    public String name;
    public int kpi;// 员工KPI

    public Staff(String name) {
        this.name = name;
        kpi = new Random().nextInt(10);
    }
    // 核心方法，接受Visitor的访问
    public abstract void accept(Visitor visitor);
}
