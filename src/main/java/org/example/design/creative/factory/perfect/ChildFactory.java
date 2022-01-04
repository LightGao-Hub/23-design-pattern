package org.example.design.creative.factory.perfect;

import org.example.design.creative.factory.simple.second.Child;
import org.example.design.creative.factory.simple.second.Person;

/**
 *  儿童单例工厂类
 *
 * Author: GL
 * Date: 2021-11-25
 */
public enum ChildFactory implements UserFactory {

    INSTANCE;

    @Override
    public Person create(String name) {
        return new Child(name);
    }
}
