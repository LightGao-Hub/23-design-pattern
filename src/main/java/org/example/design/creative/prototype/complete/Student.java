package org.example.design.creative.prototype.complete;

/**
 *  学生：实现克隆子类
 *
 * Author: GL
 * Date: 2021-12-06
 */
public class Student extends Person {

    public Student(long id, String name) {
        super(id, name);
    }

    @Override
    public void run() {
        System.out.println("Student run");
    }

    // 实现克隆函数
    @Override
    public Person prototype() {
        return new Student(super.getId(), super.getName());
    }
}
