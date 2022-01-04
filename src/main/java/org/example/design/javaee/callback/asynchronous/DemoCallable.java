package org.example.design.javaee.callback.asynchronous;

import java.util.Calendar;
import java.util.concurrent.Callable;

import lombok.extern.log4j.Log4j2;
import org.example.design.config.FinalConfig;
/**
 * Author: GL
 * Date: 2021-10-25
 */
@Log4j2
public class DemoCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        while (true) {
            Thread.sleep(FinalConfig.SLEEP_TIME);
            log.info(String.format("%s : %s", Calendar.getInstance().getTimeInMillis(), Thread.currentThread().getName()));
        }
    }
}
