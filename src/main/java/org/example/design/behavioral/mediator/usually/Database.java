package org.example.design.behavioral.mediator.usually;

/**
 *  抽象数据库父类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public interface Database<T> {

    void add(T data);

    void addData(T data);

}
