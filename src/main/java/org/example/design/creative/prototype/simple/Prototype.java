package org.example.design.creative.prototype.simple;

import lombok.Data;

/**
 *  由于此案例是基于Object的clone函数实现，故被克隆类需要实现Cloneable接口，否则JVM会抛出CloneNotSupportedException异常。
 *  代码中重写Object-clone函数, 返回子类类型, 由于函数性质没变，故没有违反迪米特原则
 *
 * Author: GL
 * Date: 2021-12-06
 */
@Data
public class Prototype implements Cloneable {
    private final long id;
    private final String name;

    @Override
    public Prototype clone() {
        try {
            return (Prototype)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
