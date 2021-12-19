package org.example.design.javaee.callback.synchronization;

/**
 *  这里实现泛型接口，设置发送消息类型和回调返回值类型!
 * Author: GL
 * Date: 2021-10-25
 */
public class MessageClient extends Client<String> implements MessageCallBack<String> {

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
        System.out.println("客户端发送请求");
        super.getServer().receive(message, this);
    }

    public MessageClient(MessageServer server) {
        super(server);
    }
}
