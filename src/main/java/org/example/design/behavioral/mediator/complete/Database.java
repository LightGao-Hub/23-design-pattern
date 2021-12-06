package org.example.design.behavioral.mediator.complete;

/**
 *  数据库父类, 需要中介类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public interface Database<T> {

    void addData(T data);

    void add(T data);

}
