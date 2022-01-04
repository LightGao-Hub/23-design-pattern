package org.example.design.behavioral.listener;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

/**
 * 被监听者
 * Author: GL
 * Date: 2021-10-24
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Log4j2
public class Servlet extends ServletSource {

    @Getter
    private final String servletName;

    public Servlet(String servletName) {
        this.servletName = servletName;
    }

    public void init() {
        log.info("init servlet");
        super.init(new ServletEvent(this));
    }

    public void destroy() {
        log.info("destroy servlet");
        super.destroyed(new ServletEvent(this));
    }


    public void process() {
        log.info("process");
        super.process(new ServletEvent(this));
    }

}
