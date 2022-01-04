package org.example.design.behavioral.mediator.complete;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

/**
 *  此案例是使用中介模式解决各组件引用依赖问题, 由中介集中管理所有引用及逻辑调用关系, 各个数据库引用中介者类即可；
 *
 *  结构：
 *      数据库接口                同事抽象父类                                  中介抽象父类[保存各个类型的实现类]                     数据库枚举类型
 *   ┌────────────────┐    ┌────────────────┐
 *   │Database<T>     │    │Colleague<K, T> │                          ┌────────────────────────────────────────────┐
 *   │└add(T data);   │    │ └mediator      │------------------------->│ AbstractMediator<E>                        │      ┌───────────────┐
 *   │└receive(T data)│    └────────────────┘                          │  └Map<K, V> dataMap                        │<-----│ DatabaseType  │
 *   │└select();      │            ▲                                   │  └register(K key, V colleague){}           │      │   └MYSQL      │
 *   └────────────────┘            │                                   │  └abstract void changed(K key, T data);    │      │   └REDIS      │
 *         ▲                       │                                   └────────────────────────────────────────────┘      │   └ES         │
 *         │                       │                                                         ▲                             └───────────────┘
 *         │                       │                                                         │
 *         │                       │     数据库父类                       ┌─────────────────────────────────────────────┐
 *         │      ┌─────────────────────────────────────────────┐       │SyncMediator                                 │
 *         └──────│AbstractDatabase<T>                          │       │  └changed(DatabaseType database, T data){}  │--changed()函数处理各个实现类之间的协调
 *                │ └final DatabaseType databaseType            │       └─────────────────────────────────────────────┘
 *                │ └add(T data){                               │
 *                │   receive(data);                            │
 *                │   getMediator().changed(DatabaseType, data);│
 *                │ };                                          │
 *                └─────────────────────────────────────────────┘
 *                                      ▲
 *        ┌─────────────────────────────┼─────────────────────────────┐
 *    ┌────────────────────┐  ┌────────────────────┐   ┌────────────────────┐
 *    │MysqlDatabase       │  │RedisDatabase       │   │EsDatabase          │
 *    │ └dataset<T>        │  │ └dataset<T>        │   │ └dataset<T>        │
 *    │ └receive(T data){} │  │ └receive(T data){} │   │ └receive(T data){} │
 *    │ └select(){}        │  │ └select(){}        │   │ └select(){}        │
 *    └────────────────────┘  └────────────────────┘   └────────────────────┘
 *
 *  总结：
 *      优点：简化了对象之间的交互, 将各同事对象解耦, 中介者有利于各同事之间的松耦合, 我们可以独立的改变和复用每一个同事和中介者, 增加新的中介者和新的同事类都比较方便, 更好地符合 "开闭原则".
 *      缺点：具体中介者类中包含了大量同事之间的交互细节, 会导致具体中介者类的逻辑非常复杂, 并且越来越臃肿, 顾实战若逻辑较少可以使用, 若逻辑过多并不建议使用
 *
 *  解决：
 *      1、建议使用简单版中介模式, 中介者只保存各个引用, 并不参与转发, 而是由各个业务类自己实现, 参考simple包
 *
 * Author: GL
 * Date: 2021-11-10
 */
@Log4j2
public class TestComplete {
    @Test
    public void test() {

        AbstractMediator<DatabaseType, String, AbstractDatabase<String>> mediator = new SyncMediator<>();

        AbstractDatabase<String> mysqlDatabase = new MysqlDatabase<>();
        AbstractDatabase<String> redisDatabase = new RedisDatabase<>();
        AbstractDatabase<String> esDatabase = new EsDatabase<>();

        // 所有引用注入
        mediator.register(DatabaseType.MYSQL, mysqlDatabase);
        mediator.register(DatabaseType.REDIS, redisDatabase);
        mediator.register(DatabaseType.ES, esDatabase);

        log.info("---------mysql 添加数据 1, 将同步到Redis和ES中----------");
        mysqlDatabase.add("1");
        mysqlDatabase.select();
        redisDatabase.select();
        esDatabase.select();

        log.info("---------Redis添加数据 2, 将不同步到其它数据库-----------");
        redisDatabase.add("2");
        mysqlDatabase.select();
        redisDatabase.select();
        esDatabase.select();

        log.info("---------ES 添加数据 3, 只同步到 Mysql-----------");
        esDatabase.add("3");
        mysqlDatabase.select();
        redisDatabase.select();
        esDatabase.select();

    }
}
