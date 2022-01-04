package org.example.design.javaee.callback.asynchronous;


import lombok.extern.log4j.Log4j2;
import org.example.design.config.FinalConfig;

/**
 * Author: GL
 * Date: 2021-10-25
 */
@Log4j2
public class MessageServer implements Server<Integer> {

    public Integer receive(Integer message) {
        try {
            Thread.sleep(message * FinalConfig.TIME_OUT);
            log.info(String.format("Message: %s, push completed", message));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
}
