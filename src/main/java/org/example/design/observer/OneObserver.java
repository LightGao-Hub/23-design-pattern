package org.example.design.observer;

import java.util.Observable;
import java.util.Observer;

/**
 *  观察者
 * Author: GL
 * Date: 2021-10-24
 */
public class OneObserver implements Observer {
    // 第一个参数可以强转成你想要的被观察者，第二个参数是被观察者类中调用:this.notifyObservers(arg); 里面的参数arg!
    @Override
    public void update(Observable o, Object arg) {
        TeacherObservable teacher = (TeacherObservable) o;
        System.out.println(String.format("观察者one, teacher = %s", teacher));
    }
}
