package org.example.design.behavioral.iterator.complete;

/**
 *  抽象array接口，所有实现类需实现add、remove函数
 *
 * Author: GL
 * Date: 2021-11-08
 */
public interface ArrayCollection<T> extends Iterable<T> {

    boolean add(T e);

}
