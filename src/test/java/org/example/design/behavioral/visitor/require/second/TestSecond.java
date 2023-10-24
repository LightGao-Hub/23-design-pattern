package org.example.design.behavioral.visitor.require.second;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

/**
 *  此案例用策略模式来间接实现访问者模式, 以此来引出访问者模式的优势
 *
 *  需求：CEO和CTO开始评定员工一年的工作绩效, 员工分为工程师和经理, CTO关注工程师的代码量、经理的新产品数量；CEO关注的是工程师的KPI和经理的KPI以及新产品数量.
 *          由于CEO和CTO对于不同员工的关注点是不一样的, 这就需要对不同员工类型进行不同的处理, 此处先使用策略模式来实现
 *
 *  结构：
 *
 *    员工类型枚举                      员工类                                         报表类                                 策略类
 *                                                                     ┌───────────────────────────────┐
 *                                 ┌────────────┐                      │ CompanyReport                 │
 *   ┌────────────┐                │Staff       │<---------------------│  └mStaffs = LinkedList<Staffs>│
 *   │StaffType   │<---------------│ └staffType │                      │  └showReport(companyStrategy) │              ┌──────────┐
 *   │ └ENGINEER  │                └────────────┘                      └───────────────────────────────┘              │ Strategy │
 *   │ └MANAGER   │                      ▲                                              ▲                             └──────────┘
 *   └────────────┘      ┌───────────────┼───────────────┐                              │                                   ▲
 *              ┌───────────────────┐        ┌──────────────────┐      ┌─────────────────────────────────┐                  │
 *              │EngineerStaff      │        │ManagerStaff      │      │ShowStaffReport                  │          ┌────────────────┐
 *              │ └getCodeLines(){} │        │ └getProducts(){} │      │ └showReport(companyStrategy){}  │<---------│CompanyStrategy │
 *              └───────────────────┘        └──────────────────┘      └─────────────────────────────────┘          │ └strategy()    │
 *                                                                                                                  └────────────────┘
 *                                                                                                                          ▲
 *                                                                                                          ┌───────────────┼──────────────┐
 *                                                                                                   ┌─────────────┐                ┌─────────────┐
 *                                                                                                   │CEOStrategy  │                │CTOStrategy  │
 *                                                                                                   └─────────────┘                └─────────────┘
 *
 *  总结：策略模式虽然可以轻松地解决此需求, 但是缺点也很明显, 在策略模式的子类实现中使用了比较丑陋的switch case 和 强转方式.
 *
 *  解决：参考complete包下的访问者模式
 *
 * Author: GL
 * Date: 2021-11-22
 */
@Log4j2
public class TestSecond {
    @Test
    public void test() {
        // 构建报表
        CompanyReport report = new ShowStaffReport();
        log.info("=========== CEO看报表 ===========");
        report.showReport(CEOStrategy.getInstance());
        log.info("=========== CTO看报表 ===========");
        report.showReport(CTOStrategy.getInstance());
    }
}
