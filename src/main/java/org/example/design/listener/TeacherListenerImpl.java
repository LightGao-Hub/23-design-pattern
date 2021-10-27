package org.example.design.listener;

/**
 *  真正实现的监听器
 * Author: GL
 * Date: 2021-10-24
 */
public class TeacherListenerImpl implements TeacherListener {

    public void teacherInitialized(TeacherEvent event) {
        final Teacher source = event.getSource();
        System.out.println(String.format("监听器函数init，打印参数：%s", source));
    }

    public void teacherDestroyed(TeacherEvent event) {
        final Teacher source = event.getSource();
        System.out.println(String.format("监听器函数destory，打印参数：%s", source));
    }
}
