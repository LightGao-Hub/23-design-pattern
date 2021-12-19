package org.example.design.behavioral.mediator.complete;

/**
 *  此案例是使用中介模式解决各组件引用依赖问题
 *
 *  结构：                        数据库父类
 *                           ┌────────────┐
 *                           │Database<T> │
 *                           └────────────┘
 *                                  ▲
 *                                  │  同事抽象父类继承数据库[引用中介类]               中介抽象父类[保存各个类型的实现类]                     数据库枚举类型
 *                         ┌─────────────────┐
 *                         │Colleague<T>     │                              ┌────────────────────────────────────────────┐
 *                         │ └mediator       │----------------------------->│ AbstractMediator<E>                        │      ┌───────────────┐
 *                         └─────────────────┘                              │  └dataMap<DatabaseType, Colleague<E>>      │<-----│ DatabaseType  │
 *                                  ▲                                       └────────────────────────────────────────────┘      │   └MYSQL      │
 *       ┌──────────────────────────┼───────────────────────┐                               ▲                                   │   └REDIS      │
 * ┌──────────────┐           ┌─────────────┐           ┌──────────┐                        │                                   │   └ES         │
 * │MysqlDatabase │           │RedisDatabase│           │EsDatabase│                 ┌────────────────┐                         └───────────────┘
 * │  └dataset    │           │  └dataset   │           │  └dataset│                 │SyncMediator    │
 * └──────────────┘           └─────────────┘           └──────────┘                 │  └changed(){}  │-changed()函数处理各个实现类之间的协调
 *                                                                                   └────────────────┘
 *
 *  总结：
 *      优点：简化了对象之间的交互，将各同事对象解耦，中介者有利于各同事之间的松耦合，我们可以独立的改变和复用每一个同事和中介者，增加新的中介者和新的同事类都比较方便，更好地符合 "开闭原则"。
 *
 *      缺点：具体中介者类中包含了大量同事之间的交互细节，会导致具体中介者类非常复杂, 此案例中的SyncMediator 的changed函数 就需要不断地更改，如果增加规则，则需要手动修改switch!
 *
 *  解决：使用中介模式 + 命令模式 将请求给changed的命令单独抽离出来！以后即使增加类型也可以通过创建命令子类来实现！参考perfect包
 *
 * Author: GL
 * Date: 2021-11-10
 */
public class Test {
    public static void main(String[] args) {

        // 新建中介实现类后存入各个业务实现类中，再由实现类反注册进中介实现类中
        AbstractMediator<String> syncMediator = new SyncMediator<>();

        MysqlDatabase<String> mysqlDatabase = new MysqlDatabase<>(syncMediator);
        RedisDatabase<String> redisDatabase = new RedisDatabase<>(syncMediator);
        EsDatabase<String> esDatabase = new EsDatabase<>(syncMediator);

        System.out.println("\n---------mysql 添加数据 1，将同步到Redis和ES中----------");
        mysqlDatabase.add("1");
        mysqlDatabase.select();
        redisDatabase.cache();
        esDatabase.count();

        System.out.println("\n---------Redis添加数据 2，将不同步到其它数据库-----------");
        redisDatabase.add("2");
        mysqlDatabase.select();
        redisDatabase.cache();
        esDatabase.count();

        System.out.println("\n---------ES 添加数据 3，只同步到 Mysql-----------");
        esDatabase.add("3");
        mysqlDatabase.select();
        redisDatabase.cache();
        esDatabase.count();

    }
}
