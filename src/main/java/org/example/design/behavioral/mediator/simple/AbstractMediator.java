package org.example.design.behavioral.mediator.simple;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import lombok.Getter;

/**
 *  简单版中介抽象父类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public abstract class AbstractMediator<K, V> {

    @Getter
    private final Map<K, V> dataMap = new ConcurrentHashMap<>();

    public void register(K key, V value) {
        Objects.requireNonNull(key, "key must not null");
        Objects.requireNonNull(value, "value must not null");
        dataMap.put(key, value);
        changed(key, value);
    }

    public V getKey(K key) {
        return dataMap.getOrDefault(key, null);
    }

    // 补充逻辑
    protected abstract void changed(K key, V value);

}
