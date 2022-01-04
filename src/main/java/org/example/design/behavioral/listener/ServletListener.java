package org.example.design.behavioral.listener;

import java.util.EventListener;

/**
 *  定义监听接口, 由实现类实现, 继承于jdk提供的监听器接口
 *
 * Author: GL
 * Date: 2021-10-24
 */
public interface ServletListener extends EventListener {

    void init(ServletEvent event);

    void process(ServletEvent event);

    void destroyed(ServletEvent event);

}
