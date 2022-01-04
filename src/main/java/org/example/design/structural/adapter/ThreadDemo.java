package org.example.design.structural.adapter;

import java.util.concurrent.Callable;

import lombok.extern.log4j.Log4j2;

/**
 * Author: GL
 * Date: 2021-10-28
 */
@Log4j2
public class ThreadDemo implements Callable<Long> {

    private final long num;

    public ThreadDemo(long num) {
        this.num = num;
    }

    public Long call() { // 累加
        long r = 0;
        for (long n = 1; n <= this.num; n++) {
            r = r + n;
        }
        log.info("Result: " + r);
        return r;
    }
}
