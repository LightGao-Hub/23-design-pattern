package org.example.design.other.callback.synchronization;

/**
 *  服务实现类
 * Author: GL
 * Date: 2021-10-25
 */
public class MessageServer implements Server<String> {

    public void receive(String message, MessageCallBack<String> callBack) {
        try {
            System.out.println(message + " 消息推送完毕");
            callBack.onSuccess("send成功");
        } catch (Exception e) {
            e.printStackTrace();
            callBack.onFailure("send失败");
        }
    }
}
