package org.example.design.behavioral.visitor.complete;

import static org.example.design.config.FinalConfig.TEN_SIZE;

import java.util.Random;

import lombok.Getter;

/**
 *  员工基类
 *
 * Author: GL
 * Date: 2021-11-24
 */
@Getter
public abstract class Staff {
    private final String name;
    private final int kpi; // 员工KPI

    public Staff(String name) {
        this.name = name;
        kpi = new Random().nextInt(TEN_SIZE);
    }
    // 核心方法, 接受Visitor的访问
    public abstract void accept(Visitor visitor);
}
