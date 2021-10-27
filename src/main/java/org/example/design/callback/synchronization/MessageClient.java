package org.example.design.callback.synchronization;

/**
 *  这里实现泛型接口，设置发送消息类型和回调返回值类型!
 * Author: GL
 * Date: 2021-10-25
 */
public class MessageClient implements Client<String> {

    private final MessageServer server;

    @Override
    public void onSuccess(String result) {
        System.out.println("进入回调函数--" + "消息推送成功," + " result:" + result);
    }

    @Override
    public void onFailure(String result) {
        System.out.println("进入回调函数--" + "消息推送失败," + " result:" + result);
    }

    // 回调的核心就是回调方将本身即this传递给调用方
    public void sendMessage(String message) {
        System.out.println("开始调用服务端进行消息的推送");
        server.send(message, this);
    }

    public MessageClient(MessageServer server) {
        this.server = server;
    }
}
