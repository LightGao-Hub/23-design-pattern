package org.example.design.adapter.two;

/**
 *  此为装饰器模式：
 *      适配器模式是Adapter，是指如果一个接口需要B接口，但是待传入的对象却是A接口，怎么办？
 *
 *      思路：你最终想通过哪个函数(B)？就去创建符合该函数需要的接口的实现类(此类为适配器)，并从类的构造器中传入需要通过的类(A)，在适配器内部进行转换即可！
 *
 *      如下例子：
 *
 *          我们想让方钉进入圆孔，那么可以看出圆孔的fits函数是我们最终想通过的，那么此函数的接口是RoundPeg，所以我们的适配器就要继承或实现此类
 *          并且我们是想让方钉通过，那么此适配器的构造函数就需要是SquarePeg类，那么剩下的就是我们在适配器内部进行转换操作了，我们可以看到圆孔的fits函数
 *          是通过调用RoundPeg的getRadius来获取半径比较半径的，那么我们此时重写适配器的getRadius即可，思路是先获取SquarePeg的宽度width 然后计算出可以适合此方钉的最小圆半径返回即可。
 *
 *      注意：适配器虽然方便，但会增加项目的复杂性，过多地使用适配器，会让系统非常零乱，不易整体进行把握。比如，明明看到调用的是 A 接口，其实内部被适配成了 B 接口的实现，
 *              一个系统如果太多出现这种情况，无异于一场灾难。因此如果不是很有必要，可以不使用适配器，而是直接对系统进行重构。
 *
 *      总结：所以适配器不是在详细设计时添加的，而是解决正在服役的项目的问题。
 *
 * Author: GL
 * Date: 2021-10-28
 */
public class Test {
    public static void main(String[] args) {
        // 圆适合圆，不足为奇。
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);
        if (hole.fits(rpeg)) {
            System.out.println("圆钉 r5 适合圆孔 r5。");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);
        // hole.fits(smallSqPeg); // 编译异常

        // 适配器解决了这个问题。
        if (hole.fits(new SquarePegAdapter(smallSqPeg))) {
            System.out.println("方钉 w2 适合圆孔 r5。");
        } else {
            System.out.println("方钉 w2 不适合圆孔 r5。");
        }

        if (hole.fits(new SquarePegAdapter(largeSqPeg))) {
            System.out.println("方钉 w20 适合圆孔 r5。");
        } else {
            System.out.println("方钉 w20 不适合圆孔 r5。");
        }
    }
}
