package org.example.design.creative.prototype.complete;

/**
 *  教师：实现克隆子类
 *
 * Author: GL
 * Date: 2021-12-06
 */
public class Teacher extends Person {

    public Teacher(long id, String name) {
        super(id, name);
    }

    @Override
    public void run() {
        System.out.println("Teacher run");
    }

    // 实现克隆函数
    @Override
    public Person prototype() {
        return new Teacher(super.getId(), super.getName());
    }
}
