package org.example.design.other.callback.synchronization;

/**
 * <p>
 *      总结：此测试回调函数是同步回调函数使用，并非异步回调函数使用，可能会有人说，这么简单的同步机制，我直接调用MessageServer.send 设置个返回值，然后在MessageClient判断不就得了吗
 *      我们想下你加返回值不还是会改动原本的函数体吗，我们回调函数可以不需要此函数的返回值，直接调用调用方的回调，所以如果是简单的函数同步可以这么做，但是如果为了解耦，为了更好的模块分离那么我们建议使用回调机制
 *      如果想用更高级的异步回调函数，请看hign包下的代码
 * <p>
 *      回调的核心就是回调方将本身即this传递给调用方，这里看messageClient.sendMessage();
 * <p>
 * Author: GL
 * Date: 2021-10-25
 */
public class Test {

    public static void main(String[] args) {
        new MessageClient(new MessageServer()).sendMessage("这是一条测试消息");
    }

}
