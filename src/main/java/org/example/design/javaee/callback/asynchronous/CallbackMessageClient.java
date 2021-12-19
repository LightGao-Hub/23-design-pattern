package org.example.design.javaee.callback.asynchronous;

/**
 *  消息请求实现类
 *
 * Author: GL
 * Date: 2021-10-25
 */
public class CallbackMessageClient extends CallbackClient<Integer> {

    public Integer send(Integer message) {
        System.out.println("开始进行异步消息的推送");
        return super.getServer().receive(message);
    }

    public void success(Integer result) {
        System.out.println(" onSuccess result: " + result);
    }

    public void failure(Throwable t) {
        System.out.println(" onFailure Throwable t.getMessage() = " + t.getMessage());
    }

    public CallbackMessageClient(Server<Integer> server) {
        super(server);
    }
}
