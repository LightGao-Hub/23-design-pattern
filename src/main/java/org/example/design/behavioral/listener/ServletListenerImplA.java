package org.example.design.behavioral.listener;

/**
 *  真正实现的监听器
 * Author: GL
 * Date: 2021-10-24
 */
public class ServletListenerImplA implements ServletListener {

    public void init(ServletEvent event) {
        final Servlet source = event.getSource();
        System.out.println(String.format("监听器A触发函数init，打印参数：%s", source));
    }

    public void destroyed(ServletEvent event) {
        final Servlet source = event.getSource();
        System.out.println(String.format("监听器A触发函数destroy，打印参数：%s", source));
    }

    @Override
    public void process(ServletEvent event) {
        final Servlet source = event.getSource();
        System.out.println(String.format("监听器A触发函数process，打印参数：%s", source));
    }
}
