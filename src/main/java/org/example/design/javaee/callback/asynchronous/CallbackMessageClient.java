package org.example.design.javaee.callback.asynchronous;

import lombok.extern.log4j.Log4j2;

/**
 *  消息请求实现类
 *
 * Author: GL
 * Date: 2021-10-25
 */
@Log4j2
public class CallbackMessageClient extends CallbackClient<Integer> {

    public Integer send(Integer message) {
        log.info("Start pushing asynchronous messages");
        return super.getServer().receive(message);
    }

    public void success(Integer result) {
        log.info(" onSuccess result: " + result);
    }

    public void failure(Throwable t) {
        log.info(" onFailure Throwable t.getMessage() = " + t.getMessage());
    }

    public CallbackMessageClient(Server<Integer> server) {
        super(server);
    }
}
