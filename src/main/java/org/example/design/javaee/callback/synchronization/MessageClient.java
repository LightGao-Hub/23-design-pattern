package org.example.design.javaee.callback.synchronization;

import lombok.extern.log4j.Log4j2;

/**
 *  这里实现泛型接口, 设置发送消息类型和回调返回值类型!
 * Author: GL
 * Date: 2021-10-25
 */
@Log4j2
public class MessageClient extends Client<String> implements MessageCallBack<String> {

    @Override
    public void onSuccess(String result) {
        log.info(String.format("Enter callback function -- message push succeeded, result: %s", result));
    }

    @Override
    public void onFailure(String result) {
        log.info(String.format("Enter callback function -- message push succeeded, result: %s", result));
    }

    // 回调的核心就是回调方将本身即this传递给调用方
    public void sendMessage(String message) {
        log.info("client poke request");
        super.getServer().receive(message, this);
    }

    public MessageClient(MessageServer server) {
        super(server);
    }
}
