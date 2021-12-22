package org.example.design.behavioral.mediator.complete;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *  中介抽象父类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public abstract class AbstractMediator<K, E> {
    // 存储数据库类型及值
    @Getter
    protected final Map<K, Colleague<K, E>> dataMap = new HashMap<>();

    public void register(K key, Colleague<K, E> colleague) {
        Objects.requireNonNull(key, "key must not null");
        Objects.requireNonNull(colleague, "colleague must not null");
        this.dataMap.put(key, colleague);
        colleague.setMediator(this);
    }

    public abstract void changed(K key, E data);
}
