package org.example.design.behavioral.responsibility.separate;

import java.util.Map;
import java.util.TreeMap;

/**
 *  优先级责任链处理抽象类，支持优先级处理，此类可以单独抽离出去供其他需要优先级队列使用
 *
 * Author: GL
 * Date: 2021-11-01
 */
public abstract class PriorityHandlerResponsibilityChain<K extends Comparable<K>, V> implements ResponsibilityChain {
    // 责任链：持有所有Handler, 并自动排序
    private final Map<K, V> handlers = new TreeMap<>();

    public Map<K, V> getHandlers() {
        return handlers;
    }
}
