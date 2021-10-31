package org.example.design.structural.flyweight;

import java.util.Random;

/**
 *  享元是一种结构型设计模式， 它允许你在消耗少量内存的情况下支持大量对象。
 *  享元模式只有一个目的： 将内存消耗最小化。 如果你的程序没有遇到内存容量不足的问题， 则可以暂时忽略该模式。
 *
 *  享元模式在Java标准库中有很多应用。我们知道，包装类型如Byte、Integer都是不变类，因此，反复创建同一个值相同的包装类型是没有必要的。
 *  以Integer为例，如果我们通过Integer.valueOf()这个静态工厂方法创建Integer实例，当传入的int范围在-128~+127之间时，会直接返回缓存的Integer实例
 *      Integer n1 = Integer.valueOf(100);
 *      Integer n2 = Integer.valueOf(100);
 *      System.out.println(n1 == n2); // true
 *
 *  如果看了Integer.valueOf的源码我们不难发现：享元模式的关键是用HashMap在内存中存储这些对象！用唯一标识码为key进行判断，如果在内存中有，则返回这个唯一标识码所标识的对象；
 *
 *  在实际应用中，享元模式主要应用于缓存，即客户端如果重复请求某些对象，不必每次查询数据库或者读取文件，而是直接返回内存中缓存的数据。
 *
 *  如下举例通过工厂方式创建100名学生后没过一个学期老师随机抽选部分学生进行考试，此时获取的便是享元模式下的数据。
 *
 * Author: GL
 * Date: 2021-10-31
 */
public class Test {

    public static void main(String[] args) {
        Random rand = new Random();

        // 创建100名学生
        for (int i = 1; i <= 100; ++i) {
            StudentFactory.create(i, String.valueOf((char) i));
        }

        // 第一学期：老师随机挑选10个学生参加考试
        for (int i = 1; i <= 10; ++i) {
            final Student student = StudentFactory.create(rand.nextInt(100),
                    String.valueOf((char) rand.nextInt(100)));
        }

        System.out.println("---------------------");

        // 第二学期：老师随机挑选20个学生参加考试
        for (int i = 1; i <= 20; ++i) {
            final Student student = StudentFactory.create(rand.nextInt(100),
                    String.valueOf((char) rand.nextInt(100)));
        }

        System.out.println("---------------------");

        // 第三学期：老师随机挑选50个学生参加考试
        for (int i = 1; i <= 50; ++i) {
            final Student student = StudentFactory.create(rand.nextInt(100),
                    String.valueOf((char) rand.nextInt(100)));
        }
    }
}
