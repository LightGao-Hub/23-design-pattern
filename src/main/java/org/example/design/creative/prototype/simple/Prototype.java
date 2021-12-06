package org.example.design.creative.prototype.simple;

import lombok.Data;

/**
 *  被克隆类需要实现Cloneable接口，否则会抛出CloneNotSupportedException异常。
 *
 * Author: GL
 * Date: 2021-12-06
 */
@Data
public class Prototype implements Cloneable {
    private final long id;
    private final String name;

    // 重写Object-clone函数，返回子类类型
    @Override
    protected Prototype clone() {
        try {
            return (Prototype)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
