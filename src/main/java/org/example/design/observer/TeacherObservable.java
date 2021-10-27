package org.example.design.observer;

import lombok.Data;

import java.util.Observable;

/**
 *  被观察者
 * Author: GL
 * Date: 2021-10-24
 */
@Data
public class TeacherObservable extends Observable {

    private String name;
    private int age;

    public void init() {
        System.out.println("初始化teacher");
        this.setChanged();
        this.notifyObservers();
    }

    public void destroy() {
        System.out.println("销毁teacher");
        this.setChanged();
        this.notifyObservers();
    }

    private void a() {
        System.out.println("其他函数a");
    }

    private void b() {
        System.out.println("其他函数b");
    }

    public TeacherObservable(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
