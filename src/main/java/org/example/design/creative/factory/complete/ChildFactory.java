package org.example.design.creative.factory.complete;

import org.example.design.creative.factory.simple.factory2.Child;
import org.example.design.creative.factory.simple.factory2.Person;

/**
 *  儿童工厂类
 *
 * Author: GL
 * Date: 2021-11-25
 */
public class ChildFactory implements UserFactory {
    @Override
    public Person create(String name) {
        return new Child(name);
    }
}
