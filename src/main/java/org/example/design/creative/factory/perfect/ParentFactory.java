package org.example.design.creative.factory.perfect;

import org.example.design.creative.factory.simple.factory2.Parent;
import org.example.design.creative.factory.simple.factory2.Person;

/**
 *  家长工厂类
 *
 * Author: GL
 * Date: 2021-11-25
 */
public enum ParentFactory implements UserFactory {

    INSTANCE;

    @Override
    public Person create(String name) {
        return new Parent(name);
    }
}
