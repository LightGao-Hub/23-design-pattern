package org.example.design.other.callback.synchronization;

/**
 *  服务接口, 提供send回调参数函数
 *
 * Author: GL
 * Date: 2021-10-25
 */
public interface Server<T> {
    void receive(T message, MessageCallBack<T> callBack);
}
