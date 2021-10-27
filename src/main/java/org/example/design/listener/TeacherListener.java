package org.example.design.listener;

import java.util.EventListener;

/**
 *  老师监听器，定义监听接口，由实现类实现，继承于jdk提供的监听器接口
 * Author: GL
 * Date: 2021-10-24
 */
public interface TeacherListener extends EventListener {

    void teacherInitialized(TeacherEvent event);

    void teacherDestroyed(TeacherEvent event);

}
