package org.example.design.creative.prototype.complete;

import org.junit.Test;

/**
 *  此案例是自定义克隆接口实现，类似Object类的clone函数思想，将需要被克隆的类实现Prototype接口后实现接口函数即可
 *  区别为我们自定义的接口且具备泛型，使得类型不再是固定为object，不再需要强转！
 *
 *  在实际开发中，我们需要考虑给Prototype类加上泛型，泛型返回的就是要克隆的类型，以此方便任何业务类的使用，
 *  而泛型类型应该是被克隆的子类的统一抽象父类！因为大多数业务中返回父类接口更符合业务的需要，即后续进行父类函数操作，也可以多态到子类的函数了！符合开闭原则
 *
 *  结构：
 *                              原型接口
 *                         ┌────────────────┐
 *                         │Prototype<T>    │
 *                         │ └T prototype() │
 *                         └────────────────┘
 *                                 ▲
 *                                 │
 *               ┌─────────────────────────────────────┐
 *               │ Person implements Prototype<Person> │
 *               └─────────────────────────────────────┘
 *                                 ▲
 *             ┌───────────────────┼───────────────────┐
 *  ┌────────────────────────┐            ┌───────────────────────┐
 *  │Student                 │            │Teacher                │
 *  │ └Person prototype(){}  │            │ └Person prototype(){} │
 *  └────────────────────────┘            └───────────────────────┘
 *
 *  总结：此方式简单易用，面对大多数不复杂场景可以轻松驾驭
 *
 * Author: GL
 * Date: 2021-12-06
 */
public class PrototypeTest {
    @Test
    public void test() {
        // 原类
        final Person student = new Student(1, "student");
        final Person teacher = new Teacher(2, "teacher");
        // 克隆
        final Person studentClone = student.prototype();
        final Person teacherClone = teacher.prototype();
        // 由于泛型的合理设计，使得函数运行无障碍
        studentClone.run();
        teacherClone.run();
    }
}
