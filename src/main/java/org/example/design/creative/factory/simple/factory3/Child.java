package org.example.design.creative.factory.simple.factory3;

import org.example.design.creative.factory.simple.factory2.Person;

/**
 *  儿童类
 *
 * Author: GL
 * Date: 2021-11-25
 */
public class Child extends Person {
    public Child(String name) {
        super(name);
    }

    public static Child getInstance(String name) {
        return new Child(name);
    }
}
