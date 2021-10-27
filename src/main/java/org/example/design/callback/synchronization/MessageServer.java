package org.example.design.callback.synchronization;

/**
 * Author: GL
 * Date: 2021-10-25
 */
public class MessageServer implements Server<String> {


    public void send(String message, Client<String> messageClient) {

        try {
            System.out.println(message + " 消息推送完毕");
            messageClient.onSuccess("send成功");
        } catch (Exception e) {
            e.printStackTrace();
            messageClient.onFailure("send失败");
        }


    }
}
