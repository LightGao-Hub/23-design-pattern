package org.example.design.behavioral.observer;

import lombok.Data;

import java.util.Observable;

/**
 *  被观察者
 * Author: GL
 * Date: 2021-10-24
 */
@Data
public class DemoObservable extends Observable {

    private String name;
    private int age;

    public void init() {
        System.out.println("初始化demo");
        this.setChanged();
        this.notifyObservers();
    }

    public void destroy() {
        System.out.println("销毁demo");
        this.setChanged();
        this.notifyObservers();
    }

    public DemoObservable(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
