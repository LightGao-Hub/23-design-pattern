package org.example.design.behavioral.listener;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 被监听者
 * Author: GL
 * Date: 2021-10-24
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Servlet extends ServletSource {

    @Getter
    private final String servletName;

    public Servlet(String servletName) {
        this.servletName = servletName;
    }

    public void init() {
        System.out.println("初始化servlet");
        super.init(new ServletEvent(this));
    }

    public void destroy() {
        System.out.println("销毁servlet");
        super.destroyed(new ServletEvent(this));
    }


    public void processA() {
        System.out.println("其他函数A");
        super.process(new ServletEvent(this));
    }

    public void processB() {
        System.out.println("其他函数B");
        super.process(new ServletEvent(this));
    }

}
