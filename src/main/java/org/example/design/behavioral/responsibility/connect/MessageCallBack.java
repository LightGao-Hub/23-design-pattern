package org.example.design.behavioral.responsibility.connect;

/**
 *  回调函数接口, 使用泛型可以让多个实现类自己选择类型！
 * Author: GL
 * Date: 2021-10-25
 */
public interface MessageCallBack<R> {
    //成功
    void onSuccess(R result);
    //失败
    void onFailure(R result);
}
