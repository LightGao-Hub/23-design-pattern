package org.example.design.javaee.callback.synchronization;

import lombok.extern.log4j.Log4j2;

/**
 *  服务实现类
 * Author: GL
 * Date: 2021-10-25
 */
@Log4j2
public class MessageServer implements Server<String> {

    public void receive(String message, MessageCallBack<String> callBack) {
        try {
            log.info(String.format("Message: %s, push completed", message));
            callBack.onSuccess("Send succeeded");
        } catch (Exception e) {
            e.printStackTrace();
            callBack.onFailure("Send failed");
        }
    }
}
