package org.example.design.behavioral.visitor.complete;

/**
 *  访问者接口, 此处的visit重载, 便是提前预知固定的类型
 *
 *  如果不使用重载则会变成如下实现：不推荐此方式, 如要使用此方式不如使用simple.second 中的策略模式
 *
 *  public void visit(Staff staff) {
 *         if (staff instanceof Manager) {
 *             Manager manager = (Manager) staff;
 *             log.info("经理: " + manager.name + ", KPI: " + manager.kpi +
 *                     ", 新产品数量: " + manager.getProducts());
 *         } else if (staff instanceof Engineer) {
 *             Engineer engineer = (Engineer) staff;
 *             log.info("工程师: " + engineer.name + ", KPI: " + engineer.kpi);
 *         }
 *   }
 *
 * Author: GL
 * Date: 2021-11-24
 */
public interface Visitor {

    // 访问工程师类型
    void visit(EngineerStaff engineerStaff);

    // 访问经理类型
    void visit(ManagerStaff managerStaff);
}
