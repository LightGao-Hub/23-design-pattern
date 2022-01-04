package org.example.design.behavioral.listener;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *  被监听者实现监听器接口, 目的是和监听器的函数保持一致, 方便监听器子类使用
 *
 * Author: GL
 * Date: 2021-11-28
 */
public abstract class ServletSource implements ServletListener {

    private final List<ServletListener> listeners = new CopyOnWriteArrayList<>();

    // 这里如果是由spring接管的话可以通过@PostConstruct 注解直接将我们需要的监听器提前注入进来！
    protected void registerListener(ServletListener listener) {
        listeners.add(listener);
    }

    public void init(ServletEvent event) {
        listeners.forEach(v -> v.init(event));
    }

    public void process(ServletEvent event) {
        listeners.forEach(v -> v.process(event));
    }

    public void destroyed(ServletEvent event) {
        listeners.forEach(v -> v.destroyed(event));
    }
}
