package org.example.design.behavioral.observer;

import java.util.Observable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;


/**
 *  被观察者
 * Author: GL
 * Date: 2021-10-24
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Log4j2
public class DemoObservable extends Observable {

    private String name;
    private int age;

    public void init() {
        log.info("init ");
        this.setChanged();
        this.notifyObservers();
    }

    public void destroy() {
        log.info("destroy ");
        this.setChanged();
        this.notifyObservers();
    }

    public DemoObservable(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
