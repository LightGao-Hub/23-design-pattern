package org.example.design.listener;

/**
 *  监听器测试类
 *
 *  理解：监听器模式和观察者模式思想大致相同，但我认为监听器模式要更为细化，因为它将事件单独抽离出来形成一个单独的接口
 *      并且被监听者一般也只会注册一个监听器，不像观察者模式Observable可以注册多个观察者，所以我认为它是单一的回调函数
 *      还有一点是监听器模式对外非常友好，因为事件区分的很好，外界只需要实现即可，而观察者则对外不友好！
 *
 *      同理servlet的监听器也是抽离的非常强清晰，比如 ServletRequestListener HttpSessionListener 监听的功能都非常单一！
 *      所以我认为监听器模式其实是观察者模式的一个更细化的模式；
 *
 *      观察者模式可以是多个观察者来实现事件驱动模型！
 *
 * Author: GL
 * Date: 2021-10-24
 */
public class Test {
    public static void main(String[] args) {
        final Teacher teacher = new Teacher("dandan", 32);
        // 注册监听
        teacher.registerListener(new TeacherListenerImpl());
        teacher.init();
        teacher.destroy();
    }
}
