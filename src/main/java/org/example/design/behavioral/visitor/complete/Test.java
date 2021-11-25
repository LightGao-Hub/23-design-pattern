package org.example.design.behavioral.visitor.complete;

/**
 *  此案例是使用访问者模式实现
 *
 *  需求：CEO和CTO开始评定员工一年的工作绩效，员工分为工程师和经理，CTO关注工程师的代码量、经理的新产品数量；CEO关注的是工程师的KPI和经理的KPI以及新产品数量。
 *       由于CEO和CTO对于不同员工的关注点是不一样的，这就需要对不同员工类型进行不同的处理，此处使用访问者模式实现
 *
 *  结构：
 *                                                                          ┌──────────────────────────────┐
 *                          ┌──────────────────┐                            │CompanyReport                 │
 *                          │Staff             │<---------------------------│ └mStaffs = LinkedList<Staffs>│
 *                          │ └accept(visitor) │                            │ └showReport(visitor)         │
 *                          └──────────────────┘                            └──────────────────────────────┘
 *                                   ▲                                                     ▲
 *                   ┌───────────────┼───────────────┐                                     │
 *          ┌──────────────────────┐        ┌──────────────────────┐           ┌────────────────────────┐
 *          │EngineerStaff         │        │ManagerStaff          │           │BusinessReport          │
 *          │ └accept(visitor) {   │        │ └accept(visitor) {   │           │ └showReport(visitor){} │
 *       ┌──│   visitor.visit(this)│        │   visitor.visit(this)│────┐      └────────────────────────┘
 *       │  │ }                    │        │ }                    │    │
 *       │  └──────────────────────┘        └──────────────────────┘    │
 *       │                                                              │
 *       │                 ┌──────────────────────┐                     │    * visitor.visit(this) 通过一次动态分派到 CEOVisitor 或 CTOVisitor
 *       │                 │Visitor               │                     │      在通过this 类型静态分配到对应的:visit(engineerStaff) 或 visit(managerStaff)！
 *       └────────────────>│ └visit(engineerStaff)│                     │
 *                         │ └visit(managerStaff) │<────────────────────┘
 *                         └──────────────────────┘
 *                                    ▲
 *                    ┌───────────────┼───────────────┐
 *    ┌──────────────────────────┐          ┌────────────────────────┐
 *    │CTOVisitor                │          │CEOVisitor              │
 *    │ └visit(engineerStaff){}  │          │ └visit(engineerStaff){}│
 *    │ └visit(managerStaff){}   │          │ └visit(managerStaff){} │
 *    └──────────────────────────┘          └────────────────────────┘
 *
 *
 *  总结:
 *      1、访问者模式最大的优点就是增加访问者非常容易，我们从代码中可以看到，如果要增加一个访问者，只要新实现一个 Visitor
 *         接口的类，从而达到数据对象与数据操作相分离的效果。如果不实用访问者模式，而又不想对不同的元素进行不同的操作，那么必定需要使用 if-else 和类型转换，这使得代码难以升级维护。
 *      2、访问者模式主要用于集合中数据类型不变，但针对不同类型所实现的逻辑不同的情况！
 *      3、访问者模式主要使用了静态分配来解决了java的动态单分配的缺陷！
 *      4、我们要根据具体情况来评估是否适合使用访问者模式，例如，我们的元素类型是否足够稳定，如果经常更改元素的类型，则不适用访问者模式！
 *
 * Author: GL
 * Date: 2021-11-23
 */
public class Test {
    public static void main(String[] args) {
        // 构建报表
        CompanyReport report = new BusinessReport();
        System.out.println("=========== CEO看报表 ===========");
        report.showReport(new CEOVisitor());
        System.out.println("=========== CTO看报表 ===========");
        report.showReport(new CTOVisitor());
    }
}
