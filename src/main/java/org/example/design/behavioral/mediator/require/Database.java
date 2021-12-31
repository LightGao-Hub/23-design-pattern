package org.example.design.behavioral.mediator.require;

/**
 *  数据库接口
 *
 * Author: GL
 * Date: 2021-11-10
 */
public interface Database<T> {

    void add(T data);

    void receive(T data);

    void select();

}
