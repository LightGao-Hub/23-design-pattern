package org.example.design.behavioral.listener;

import java.util.EventObject;

/**
 *  监听的事件, 继承于jdk提供的事件类
 * Author: GL
 * Date: 2021-10-24
 */
public class ServletEvent extends EventObject {

    public ServletEvent(Servlet source) {
        super(source);
    }

    public Servlet getSource() {
        return (Servlet) this.source;
    }
}
