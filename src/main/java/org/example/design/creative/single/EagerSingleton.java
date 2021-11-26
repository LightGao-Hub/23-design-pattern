package org.example.design.creative.single;

/**
 *  饿汉式单例：虽然是static修饰的成员变量，但并不保障一定是懒加载，因为此类加载的方式有很多，
 *  假设此类有其他静态变量或函数被调用，那么就会加载到instance变量，从而变成了非懒加载单例
 *
 * Author: GL
 * Date: 2021-11-24
 */
public class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();

    /**
     * 私有默认构造子
     */
    private EagerSingleton(){
    }

    /**
     * 静态工厂方法
     */
    public static EagerSingleton getInstance(){
        return instance;
    }
}
