package org.example.design.creative.factory.simple.third;

import org.example.design.creative.factory.simple.second.Person;

/**
 *  家长类
 *
 * Author: GL
 * Date: 2021-11-25
 */
public class Parent extends Person {
    public Parent(String name) {
        super(name);
    }

    public static Parent getInstance(String name) {
        return new Parent(name);
    }
}
