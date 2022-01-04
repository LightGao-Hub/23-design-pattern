package org.example.design.behavioral.observer;

import java.util.Observable;
import java.util.Observer;

import lombok.extern.log4j.Log4j2;

/**
 *  观察者
 * Author: GL
 * Date: 2021-10-24
 */
@Log4j2
public class FirstObserver implements Observer {
    // 第一个参数可以强转成你想要的被观察者, 第二个参数是被观察者类中调用:this.notifyObservers(arg); 里面的参数arg
    @Override
    public void update(Observable o, Object arg) {
        DemoObservable demo = (DemoObservable) o;
        log.info(String.format("FirstObserver, Observable = %s", demo));
    }
}
