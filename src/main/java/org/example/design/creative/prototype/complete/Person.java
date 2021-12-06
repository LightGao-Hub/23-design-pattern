package org.example.design.creative.prototype.complete;

import lombok.Getter;
import lombok.ToString;

/**
 *  被克隆父类, 注意指定接口泛型为自身类型
 *
 * Author: GL
 * Date: 2021-12-06
 */
@ToString
public abstract class Person implements Prototype<Person> {
    @Getter
    private final long id;
    @Getter
    private final String name;

    protected Person(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void run(); // 父类抽象接口
}
