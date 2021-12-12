package org.example.design.principle.four;

/**
 *   接口隔离原则，详细请看：https:// app.yinxiang.com/fx/fcb5b15c-febd-4dca-b7e5-3d1ca300fd65
 *
 *   接口隔离原则（Interface Segregation Principle，ISP）要求程序员尽量将臃肿庞大的接口拆分成更小的和更具体的接口，让接口中只包含客户感兴趣的方法。
 *      要为各个类建立它们需要的专用接口，而不要试图去建立一个很庞大的接口供所有依赖它的类去调用。
 *
 *   接口隔离原则和单一职责都是为了提高类的内聚性、降低它们之间的耦合性，体现了封装的思想，但两者是不同的：
 *      单一职责原则注重的是职责，而接口隔离原则注重的是对接口依赖的隔离。
 *      单一职责原则主要是约束类，它针对的是程序中的实现和细节；接口隔离原则主要约束接口，主要针对抽象和程序整体框架的构建。
 *
 *   接口隔离原则的实现方法
 *      在具体应用接口隔离原则时，应该根据以下几个规则来衡量。
 *      接口尽量小，但是要有限度。一个接口只服务于一个子模块或业务逻辑。
 *      为依赖接口的类定制服务。只提供调用者需要的方法，屏蔽不需要的方法。
 *      了解环境，拒绝盲从。每个项目或产品都有选定的环境因素，环境不同，接口拆分的标准就不同深入了解业务逻辑。
 *      提高内聚，减少对外交互。使接口用最少的方法去完成最多的事情。
 *
 *   个人理解：对于接口大小的把握，需要有度。这需要经验做支撑。个人觉得拿不准的情况下，做小比做大好点。因为后期做加法比做减法容易。
 *
 * Author: GL
 * Date: 2021-12-10
 */
public class Explain {
    public static void main(String[] args) {
        StuScoreList.INSTANCE.insert();
        StuScoreList.INSTANCE.countTotalScore();
        StuScoreList.INSTANCE.printStuInfo();
        StuScoreList.INSTANCE.delete();
    }
}

// 输入模块接口
interface InputModule {
    void insert();
    void delete();
    void modify();
}

// 统计模块接口
interface CountModule {
    void countTotalScore();
    void countAverage();
}

// 打印模块接口
interface PrintModule {
    void printStuInfo();
    void queryStuInfo();
}
// 单例实现类
enum StuScoreList implements InputModule, CountModule, PrintModule {

    INSTANCE;

    public void insert() {
        System.out.println("输入模块的insert()方法被调用！");
    }
    public void delete() {
        System.out.println("输入模块的delete()方法被调用！");
    }
    public void modify() {
        System.out.println("输入模块的modify()方法被调用！");
    }
    public void countTotalScore() {
        System.out.println("统计模块的countTotalScore()方法被调用！");
    }
    public void countAverage() {
        System.out.println("统计模块的countAverage()方法被调用！");
    }
    public void printStuInfo() {
        System.out.println("打印模块的printStuInfo()方法被调用！");
    }
    public void queryStuInfo() {
        System.out.println("打印模块的queryStuInfo()方法被调用！");
    }
}
