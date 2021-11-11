package org.example.design.behavioral.mediator.usually;

/**
 * 本案例提供一种数据库场景：不使用中介模式
 *
 *       我们来实现一个简化版的案例，有三种数据库 Mysql、Redis、Elasticsearch，其中的 Mysql 作为主数据库，当增加一条数据时需要同步到另外两个数据库中；
 *
 *       Redis作为缓存数据库，当增加一条数据时不需要同步到另外两个个数据库；
 *
 *       Elasticsearch 作为大数据查询数据库，有一个统计功能，当增加一条数据时只需要同步到 Mysql
 *
 * 结构：
 *
 *                          ┌─────────────────┐
 *                          │AbstractDatabase │
 *                          └─────────────────┘
 *                                   ▲
 *        ┌──────────────────────────┼───────────────────────┐
 *  ┌──────────────┐           ┌─────────────┐           ┌──────────┐
 *  │MysqlDatabase │ <-------> │RedisDatabase│ <-------> │EsDatabase│
 *  │  └dataset    │           │  └dataset   │           │  └dataset│
 *  └──────────────┘           └─────────────┘           └──────────┘
 *
 * 总结：缺点很多
 *  系统结构复杂且耦合度高。数据源需要维护目标端数据库的引用，以便完成数据同步
 *  组件的可重用性差。由于每一个数据源和目标端之间具有很强的关联，若没有目标端的支持，这个组件很难被另一个系统或模块重用
 *  系统的可扩展性差：如果需要增加、修改或删除其中一个数据库、将导致多个类的源代码需要修改，这违反了 "开闭原则"，可扩展性和灵活性欠佳。
 *
 * 解决：参考complete包
 *
 * Author: GL
 * Date: 2021-11-10
 */
public class Test {
    public static void main(String[] args) {
        MysqlDatabase<String> mysqlDatabase = new MysqlDatabase<>();
        RedisDatabase<String> redisDatabase = new RedisDatabase<>();
        EsDatabase<String> esDatabase = new EsDatabase<>();

        mysqlDatabase.setRedisDatabase(redisDatabase);
        mysqlDatabase.setEsDatabase(esDatabase);
        esDatabase.setMysqlDatabase(mysqlDatabase);

        System.out.println("\n---------mysql 添加数据 1，将同步到Redis和ES中-----------");
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
