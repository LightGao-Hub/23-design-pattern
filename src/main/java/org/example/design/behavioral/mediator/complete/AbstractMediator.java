package org.example.design.behavioral.mediator.complete;

import lombok.Getter;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  中介抽象父类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public abstract class AbstractMediator<K, T, V extends Colleague<K, T>> {
    // 存储数据库类型及值
    @Getter
    private final Map<K, V> dataMap = new ConcurrentHashMap<>();

    public void register(K key, V colleague) {
        Objects.requireNonNull(key, "key must not null");
        Objects.requireNonNull(colleague, "colleague must not null");
        dataMap.put(key, colleague);
        colleague.setMediator(this); // 在此注册函数将中介类反注册进colleague类中，因此MysqlDatabase等子类无需知道中介类的存在
    }

    public abstract void changed(K key, T data);
}
