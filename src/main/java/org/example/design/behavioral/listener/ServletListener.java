package org.example.design.behavioral.listener;

import java.util.EventListener;

/**
 *  老师监听器，定义监听接口，由实现类实现，继承于jdk提供的监听器接口
 *  注意：接口函数要定义好监听的事件类型，子类无需强转
 * Author: GL
 * Date: 2021-10-24
 */
public interface ServletListener extends EventListener {

    void init(ServletEvent event);

    void process(ServletEvent event);

    void destroyed(ServletEvent event);

}
