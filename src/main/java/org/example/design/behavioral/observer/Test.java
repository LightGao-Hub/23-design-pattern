package org.example.design.behavioral.observer;

/**
 *  和监听器比起来我们发现，观察者模式更加灵活，可以设置多个观察者，并且根据需要进行强转，不过对外不友好
 *  所以在servlet容器中，使用监听器是因为对外更加友好，因为粒度很细，适合外部使用！
 *
 * Author: GL
 * Date: 2021-10-24
 */
public class Test {
    public static void main(String[] args) {
        // 创建被观察者
        TeacherObservable teacher = new TeacherObservable("dandan", 32);
        // 注入观察者，注意：观察者的添加是有顺序的，目前是stack数据结构，后进先出
        teacher.addObserver(new TwoObserver());
        teacher.addObserver(new OneObserver());
        // 触发事件驱动
        teacher.init();
        teacher.destroy();
    }
}
