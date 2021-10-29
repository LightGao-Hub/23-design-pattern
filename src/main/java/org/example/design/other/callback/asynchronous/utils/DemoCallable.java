package org.example.design.other.callback.asynchronous.utils;

import java.util.Calendar;
import java.util.concurrent.Callable;

/**
 * Author: GL
 * Date: 2021-10-25
 */
public class DemoCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        while (true) {
            Thread.sleep(1000);
            String str = Calendar.getInstance().getTimeInMillis() + " : " + Thread.currentThread().getName();
            System.out.println(str);
        }
    }
}
