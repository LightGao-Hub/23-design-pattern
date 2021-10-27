package org.example.design.listener;

import lombok.Data;

/**
 * 被监听者
 * Author: GL
 * Date: 2021-10-24
 */
@Data
public class Teacher implements Source {

    private String name;
    private int age;

    // 监听器 & 注册
    private TeacherListener listener;

    // 这里如果是由spring接管的话可以通过@PostConstruct 注解直接将我们需要的监听器提前注入进来！
    public void registerListener(TeacherListener listener) {
        this.listener = listener;
    }

    public void init() {
        System.out.println("初始化teacher");
        if (listener != null) {
            TeacherEvent even = new TeacherEvent(this);
            this.listener.teacherInitialized(even);
        }
    }

    public void destroy() {
        System.out.println("销毁teacher");
        if (listener != null) {
            TeacherEvent even = new TeacherEvent(this);
            this.listener.teacherDestroyed(even);
        }
    }


    private void a() {
        System.out.println("其他函数a");
    }

    private void b() {
        System.out.println("其他函数b");
    }

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
