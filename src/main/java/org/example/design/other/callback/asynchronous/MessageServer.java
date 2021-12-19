package org.example.design.other.callback.asynchronous;


/**
 * Author: GL
 * Date: 2021-10-25
 */
public class MessageServer implements Server<Integer> {

    public Integer receive(Integer message) {
        try {
            Thread.sleep(message * 1000);
            System.out.println(message + " 消息推送完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
}
