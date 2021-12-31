package org.example.design.behavioral.mediator.complete;

import lombok.Data;

/**
 *  同事类
 *
 * Author: GL
 * Date: 2021-12-26
 */
@Data
public abstract class Colleague<K, T> {
    private AbstractMediator<K, T, ? extends Colleague<K ,T>> mediator;    // 中介者
}
