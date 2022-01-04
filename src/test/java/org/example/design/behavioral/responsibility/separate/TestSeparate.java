package org.example.design.behavioral.responsibility.separate;

import org.junit.Test;

import java.math.BigDecimal;

/**
 *  本案例实现了分离版责任链模式
 *
 *  结构：
 *                         责任链处理接口                                      请求接口                          责任链容器接口
 *                         ┌─────────┐
 *                         │ Handler │                                 ┌─────────┐                      ┌─────────────────────┐
 *                         └─────────┘                                 │ Request │                      │ ResponsibilityChain │
 *                              ▲                                      └─────────┘                      └─────────────────────┘
 *                              │                                          ▲                                      ▲
 *               ┌──────────────────────────────────┐                      │                                      │
 *  财务处理器象类-│FinanceHandler                    │               ┌───────────────┐              ┌───────────────────────────────────┐
 *               │ └Boolean process(FinanceRequest) │<--------------│FinanceRequest │-公司财务请求   │PriorityHandlerResponsibilityChain │-优先级责任链容器, 支持优先级处理
 *               └──────────────────────────────────┘               └───────────────┘              │  -TreeMap[存放责任链处理类]          │
 *                              ▲                                                                  └───────────────────────────────────┘
 *                              │                                                                                 ▲
 *             ┌────────────────┼───────────────┐                                                                 │
 * ┌──────────────────────┐             ┌──────────────────────┐                                  ┌──────────────────────────────────┐
 * │ManagerFinanceHandler │             │DirectorFinanceHandler│                                  │FinancePriorityResponsibilityChain│-公司财务实现的基于优先级责任链容器
 * └──────────────────────┘             └──────────────────────┘                                  └──────────────────────────────────┘
 *      主任处理类                               管理者处理类
 *
 *  责任链模式和观察者模式的区别：
 *      责任链按照顺序将请求动态传递给一系列的潜在接收者, 直至其中一名接收者对请求进行处理.
 *      观察者允许所有接收者都接受此请求, 并且分别执行不同的逻辑！
 *
 * Author: GL
 * Date: 2021-10-31
 */
public class TestSeparate {
    // 由于责任链模式是在请求到来之前就要构件好责任链, 所以此处通过静态代码块模拟请求来到时构建责任链完成;
    private static final PriorityHandlerResponsibilityChain<Double, FinanceHandler<Double>, FinanceRequest> handlerChainTreeMap;

    static {
        final ManagerFinanceHandler managerHandler = new ManagerFinanceHandler(1.0, BigDecimal.valueOf(1000.0));
        final DirectorFinanceHandler directorHandler = new DirectorFinanceHandler(2.0, BigDecimal.valueOf(2000.0));
        handlerChainTreeMap = new FinancePriorityResponsibilityChain<>(); // 此处创建可以通过工厂模式创建
        handlerChainTreeMap.addHandler(directorHandler);
        handlerChainTreeMap.addHandler(managerHandler);
    }

    @Test
    public void test() {
        handlerChainTreeMap.process(new FinanceRequest("Jack Ma", BigDecimal.valueOf(1500.0)));
    }
}
