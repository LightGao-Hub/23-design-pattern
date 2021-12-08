package org.example.design.principle.two;

/**
 *  里式替换原则，详细请看：https://app.yinxiang.com/fx/c3be1162-6aa3-4132-807f-9a20e4a52ec1
 *
 *  里氏替换原则通俗的来讲就是：子类可以扩展父类的功能，但不能改变父类原有的功能。也就是说：子类继承父类时，除添加新的方法完成新增功能外，尽量不要重写父类的方法。
 *
 *  但是！个人理解：
 *      里氏代换原则的意思并不是“子类不能重写父类的方法”，而是“子类重写父类方法时，可以改变方法的具体行为，但不应该改变方法的用途”。
 *      比如父类有一个排序功能，子类可以重写来改变排序的算法，但不应该改变排序这个功能！
 *
 * Author: GL
 * Date: 2021-12-08
 */
public class Explain {
    public static void main(String[] args) {
        Bird bird1 = new Swallow();
        Bird bird2 = new BrownKiwi();
        bird1.setSpeed(120);
        bird2.setSpeed(120);
        System.out.println("如果飞行300公里：");
        try {
            System.out.println("燕子将飞行" + bird1.getFlyTime(300) + "小时.");
            System.out.println("几维鸟将飞行" + bird2.getFlyTime(300) + "小时。");
        } catch (Exception err) {
            System.out.println("发生错误了!");
        }
    }
}

//鸟类
class Bird {
    double flySpeed;
    public void setSpeed(double speed) {
        flySpeed = speed;
    }
    public double getFlyTime(double distance) {
        return distance / flySpeed;
    }
}

//燕子类
class Swallow extends Bird {
}


//几维鸟类
class BrownKiwi extends Bird {
    public void setSpeed(double speed) {
        flySpeed = 0;
    }
}