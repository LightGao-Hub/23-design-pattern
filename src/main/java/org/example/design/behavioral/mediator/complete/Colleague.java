package org.example.design.behavioral.mediator.complete;

import lombok.Getter;
import lombok.Setter;

/**
 *  抽象同事类, 继承Database接口，否则在中介者类无法调用Database接口函数
 *
 * Author: GL
 * Date: 2021-12-05
 */
public abstract class Colleague<K, E> implements Database<E> {
    @Getter
    @Setter
    private AbstractMediator<K, E> mediator;    // 中介者

}
