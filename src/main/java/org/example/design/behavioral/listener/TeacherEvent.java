package org.example.design.behavioral.listener;

import java.util.EventObject;

/**
 *  监听的事件，继承于jdk提供的事件类
 * Author: GL
 * Date: 2021-10-24
 */
public class TeacherEvent extends EventObject {

    public TeacherEvent(Teacher source) {
        super(source);
    }

    public Teacher getSource() {
        return (Teacher) this.source;
    }
}
