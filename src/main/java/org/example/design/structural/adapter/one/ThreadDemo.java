package org.example.design.structural.adapter.one;

import java.util.concurrent.Callable;

/**
 * Author: GL
 * Date: 2021-10-28
 */
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
        System.out.println("Result: " + r);
        return r;
    }
}
