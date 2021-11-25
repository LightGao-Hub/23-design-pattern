package org.example.design.creative.factory.simple.factory2;

import lombok.Getter;
import lombok.ToString;

/**
 *  人类
 *
 * Author: GL
 * Date: 2021-11-25
 */
@ToString
public abstract class Person {
    @Getter
    private final String name;

    protected Person(String name) {
        this.name = name;
    }
}
