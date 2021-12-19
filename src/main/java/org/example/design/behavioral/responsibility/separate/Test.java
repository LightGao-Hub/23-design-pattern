package org.example.design.behavioral.responsibility.separate;

import java.math.BigDecimal;

/**
 *  责任链模式是一种行为设计模式， 允许你将请求沿着处理者链进行发送。 收到请求后， 每个处理者均可对请求进行处理， 或将其传递给链上的下个处理者。
 *  详见图片：./picture/chain_of_responsibility/chain-of-responsibility-2x.png
 *
 *  在实际场景中，财务审批就是一个责任链模式。假设某个员工需要报销一笔费用，审核者可以分为：
 *      Manager：直属领导只能审核1000元以下的报销；
 *      Director：主任只能审核2000元以下的报销；
 *      CEO：可以审核任意额度。
 *
 *  用责任链模式设计此报销流程时，每个审核者只关心自己责任范围内的请求，并且处理它。对于超出自己责任范围的，扔给下一个审核者处理，这样，将来继续添加审核者的时候，不用改动现有逻辑。
 *
 *  适用场景：
 *      1、当程序需要使用不同方式处理不同种类请求，而且请求类型和顺序预先未知时，可以使用责任链模式：该模式能将多个处理者连接成一条链。 接收到请求后， 它会 “询问” 每个处理者是否能够对其进行处理。 这样所有处理者都有机会来处理请求。
 *      2、当必须按顺序执行多个处理者时，可以使用该模式：无论你以何种顺序将处理者连接成一条链， 所有请求都会严格按照顺序通过链上的处理者。
 *
 *  实现：责任链模式有较多实现变体，大体可以分成两种：
 *      1、分离[本案例]：将处理责任链的逻辑单独抽离出来，内部维护一个队列或优先级队列，然后通过调用处理函数进行循环队列进行处理
 *      2、连接[看connect包]：将每一个处理器handler内部都维护一个下一个handler的变量，只需调用最外层的handler即可在内部不断判断，如果通过则返回，不通过则用变量的handler处理，依次调用
 *
 *  结构：
 *                         处理标识接口                        请求标识接口                             责任链表标识接口
 *                         ┌─────────┐                       ┌─────────┐                       ┌─────────────────────┐
 *                         │ Handler │                       │ Request │                       │ ResponsibilityChain │
 *                         └─────────┘                       └─────────┘                       └─────────────────────┘
 *                              ▲                                ▲                                       ▲
 *                              │                                │                                       │
 *                       ┌───────────────┐                 ┌───────────────┐              ┌───────────────────────────────────┐
 *         财务处理器抽象类-│FinanceHandler │                 │FinanceRequest │-公司财务请求   │PriorityHandlerResponsibilityChain │-优先级责任链处理抽象类，支持优先级处理
 *                       └───────────────┘                 └───────────────┘              │  -TreeMap[存放责任链]               │
 *                              ▲                                                         └───────────────────────────────────┘
 *                              │                                                                        ▲
 *     ┌────────────────────────┼───────────────┐                                                        │
 * ┌──────────────────────┐        ┌──────────────────────┐                               ┌──────────────────────────────────┐
 * │ManagerFinanceHandler │        │DirectorFinanceHandler│                               │FinancePriorityResponsibilityChain│-公司财务实现的基于优先级责任链实现类
 * └──────────────────────┘        └──────────────────────┘                               └──────────────────────────────────┘
 *
 *
 *  责任链模式和观察者模式的区别：
 *      责任链按照顺序将请求动态传递给一系列的潜在接收者，直至其中一名接收者对请求进行处理。
 *      观察者允许所有接收者都接受此请求，并且分别执行不同的逻辑！
 *
 * Author: GL
 * Date: 2021-10-31
 */
public class Test {
    // 由于责任链模式是在请求到来之前就要构件好责任链，所以此处通过静态代码块模拟请求来到时构建责任链完成;
    private static final FinancePriorityResponsibilityChain<Double, FinanceHandler<Double>> handlerChainTreeMap;

    static {
        final ManagerFinanceHandler managerHandler = new ManagerFinanceHandler(1.0, BigDecimal.valueOf(1000.0));
        final DirectorFinanceHandler directorHandler = new DirectorFinanceHandler(2.0, BigDecimal.valueOf(2000.0));
        handlerChainTreeMap = new FinancePriorityResponsibilityChain<>(); // 此处创建可以通过工厂模式创建
        handlerChainTreeMap.addHandler(directorHandler);
        handlerChainTreeMap.addHandler(managerHandler);
    }

    public static void main(String[] args) {
        System.out.println(handlerChainTreeMap.process(new FinanceRequest("liJie", BigDecimal.valueOf(1500.0))));
    }
}
