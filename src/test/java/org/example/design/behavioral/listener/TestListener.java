package org.example.design.behavioral.listener;

import org.junit.Test;

/**
 *  监听器测试类：本案例模仿javaWeb中servlet监听器实现.
 *
 *  理解：
 *      监听器模式和观察者模式思想大致相同, 但我认为监听器模式要更方便, 更细化, 因为它将事件单独抽离出来形成一个单独的类
 *      几个监听器和被监听器是针对某一个业务类[例如Servlet业务类]而衍生出来的, 被监听者可以注册多个监听器, 但监听事件类型是单一类型, 无需强转！
 *      监听器模式对外非常友好, 因为事件区分的很好[事件类型明确], 外界只需要实现即可[拿到的事件不需要强转], 而观察者则对外不友好[拿到的被观察者需要强转]！
 *
 *      同理servlet的监听器也是抽离的清晰, 比如 ServletRequestListener HttpSessionListener 监听的功能和事件都很单一[可以看源码, 监听的事件也是单独写死]
 *      并且事件不需要强转, 因为接口ServletRequestListener 已经定义好了函数的事件类型, 子类只需要实现即可
 *      所以我认为监听器模式其实是观察者模式的一个更细化的模式；
 *
 *  结构：
 *
 *               事件对象父类[jdk提供]                  事件监听父类[jdk提供]
 *                                                     ┌──────────────┐
 *                ┌─────────────┐                      │EventListener │
 *                │ EventObject │                      └──────────────┘
 *                └─────────────┘                             ▲
 *                       ▲                                    │
 *                       │                    ┌─────────────────────────────────┐
 *                ┌───────────────┐           │ServletListener                  │
 *                │ServletEvent   │<----------│ └init(ServletEvent event)       │
 *                │ └getSource(){}│           │ └process(ServletEvent event)    │
 *                └───────────────┘           │ └destroyed(ServletEvent event)  │
 *                                            └─────────────────────────────────┘
 *                               被监听者父类                   ▲                     监听者类, 可以有多个
 *                                 ┌──────────────────────────┼───────────────────────────┐─────────────────────────────────────────┐
 * ┌────────────────────────────────────────────────┐                   ┌─────────────────────────────────┐     ┌─────────────────────────────────┐
 * │ServletSource                                   │                   │ServletListenerImplA             │     │ServletListenerImplB             │
 * │ └List<ServletListener> listeners               │                   │ └init(ServletEvent event){}     │     │ └init(ServletEvent event){}     │
 * │ └registerListener(ServletListener listener) {} │                   │ └process(ServletEvent event){}  │     │ └process(ServletEvent event){}  │
 * │ └init(ServletEvent event){}                    │                   │ └destroyed(ServletEvent event){}│     │ └destroyed(ServletEvent event){}│
 * │ └process(ServletEvent event){}                 │                   └─────────────────────────────────┘     └─────────────────────────────────┘
 * │ └destroyed(ServletEvent event){}               │
 * └────────────────────────────────────────────────┘
 *                      ▲
 *                      │
 *                  ┌────────┐
 *                  │Servlet │
 *                  └────────┘
 *         被监听类, 根据需求触发父类函数引发监听
 *
 *
 *  总结：
 *      在项目设计中, 可以考虑为某个关键的业务类设置被监听口子[例如本案例的Servlet], 方便在后续开发中对复杂业务需求的扩展[只需继承监听类即可完成若干复杂操作], 十分方便.
 *
 * Author: GL
 * Date: 2021-10-24
 */
public class TestListener {
    @Test
    public void test() {
        final Servlet servlet = new Servlet("servletDemo");
        // 创建多个servlet监听器
        final ServletListener servletListenerA = new ServletListenerImplA();
        final ServletListener servletListenerB = new ServletListenerImplB();
        // 注册多个监听
        servlet.registerListener(servletListenerA);
        servlet.registerListener(servletListenerB);
        // 调用被监听函数
        servlet.init();
        servlet.destroy();
        servlet.process();
    }
}
