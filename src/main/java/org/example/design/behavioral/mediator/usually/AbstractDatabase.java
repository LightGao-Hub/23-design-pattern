package org.example.design.behavioral.mediator.usually;

/**
 *  抽象数据库父类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public abstract class AbstractDatabase<T> {

    public abstract void add(T data);

    public abstract void addData(T data);

}
