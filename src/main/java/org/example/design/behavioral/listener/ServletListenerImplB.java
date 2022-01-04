package org.example.design.behavioral.listener;

import lombok.extern.log4j.Log4j2;

/**
 *  真正实现的监听器
 * Author: GL
 * Date: 2021-10-24
 */
@Log4j2
public class ServletListenerImplB implements ServletListener {

    public void init(ServletEvent event) {
        final Servlet source = event.getSource();
        log.info(String.format("Listener B trigger function init, Print parameters：%s", source));
    }

    public void destroyed(ServletEvent event) {
        final Servlet source = event.getSource();
        log.info(String.format("Listener B trigger function destroy, Print parameters：%s", source));
    }

    @Override
    public void process(ServletEvent event) {
        final Servlet source = event.getSource();
        log.info(String.format("Listener B trigger function process, Print parameters：%s", source));
    }
}
