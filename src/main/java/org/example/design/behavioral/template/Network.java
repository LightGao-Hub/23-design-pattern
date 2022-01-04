package org.example.design.behavioral.template;

import lombok.Getter;

/**
 *  网络通讯父类, 定义模板函数
 *
 * Author: GL
 * Date: 2021-11-22
 */
public abstract class Network {
    @Getter
    private final String userName;
    @Getter
    private final String password;

    public Network(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * 模型算法骨架, 注意要设置为protected final, 不被子类重写！
     */
    protected final void post(String message) {
        if (logIn(this.userName, this.password)) {
            sendData(message.getBytes());
            logOut();
        }
    }

    abstract boolean logIn(String userName, String password);
    abstract void sendData(byte[] data);
    abstract void logOut();
}
