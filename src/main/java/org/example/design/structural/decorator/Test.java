package org.example.design.structural.decorator;

/**
 * 装饰是一种结构设计模式， 允许你通过将对象放入特殊封装对象中来为原对象增加新的行为。
 *
 *   在java的IO流中我们就曾使用过装饰器模式，例如：
 *
 *   InputStream input = new GZIPInputStream( // 第二层装饰
 *                      new BufferedInputStream( // 第一层装饰
 *                          new FileInputStream("test.gz") // 核心功能));
 *
 *   根据IO流的例子，我们将装饰器的结构一般设置如下：
 *                   ┌─────────────┐
 *                   │ InputStream │ 统一抽象接口
 *                   └─────────────┘
 *                         ▲
 *            ┌────────────┼─────────────────┐
 *            │                              │
 *      ┌────────────────┐             ┌───────────┐
 *      │FileInputStream │ 具体实现类    │ Decorator │ 装饰器
 *      └────────────────┘             └───────────┘
 *                                           ▲
 *                                 ┌─────────┴────────┐
 *                                 │                  │
 *                     ┌────────────────────┐ ┌────────────────────┐
 *                     │BufferedInputStream │ │GZIPInputStream     │...
 *                     └────────────────────┘ └────────────────────┘
 * <p>
 *      Decorator模式有什么好处？它实际上把核心功能和附加功能给分开了。核心功能指FileInputStream这些真正读数据的源头，
 *      附加功能指加缓冲、压缩、解密这些功能。如果我们要新增核心功能，就增加类似FileInputStream这种类，例如ByteInputStream。
 *      如果我们要增加附加功能，就增加Decorator的子类，例如CipherInputStream(加密解密流-属于附属功能)。
 *      两部分都可以独立地扩展，而具体如何附加功能，由调用方自由组合，从而极大地增强了灵活性。
 * <p>
 *      实现核心：Decorator父类中保存InputStream顶级接口的成员变量input，并且在Decorator的子类BufferedInputStream构造方法中传入InputStream变量
 *      由于Decorator实现了InputStream接口，此时附加功能就可以在InputStream的read或write函数中扩展，但是具体的核心读取文件这一步还是得调用里面的成员变量input.read来读取核心文件
 *      以此来实现附属功能的开发！
 * <p>
 *      实现看代码
 * <p>
 *      总结：
 * <p>
 *      1、当系统需要新功能时，一般是向旧的类中添加新的代码。这些新的代码通常装饰了原有类的核心职责或主要行为。
 *      但这种做法的问题在于，他们在主类中加入了新的字段、新的方法和新的逻辑，从而增加了主类的复杂度，而这些新加入的东西仅仅是为了满足一些只在某种特定情况下才会执行的特殊行为的需要。
 *      装饰模式提供了一种非常好的解决方案，它把每个要装饰的功能放在单独的类中，并让这个类包装它所要装饰的对象，因此，当需要执行特殊行为时，客户代码就可以根据需要、有选择按顺序的使用装饰功能包装对象；
 * <p>
 *      2、装饰和代理有着极其相似的结构， 都是通过构造函数将真是业务类存储为变量，并通过实现共同接口的重写来增强真实业务的函数，
 *      但是其意图却非常不同。这块可以看代理模式下的代码注释，简洁来说：
 *      在代理模式中，用户拿到的就是一个代理类userDaoProxy，对于里面的UserDao的实现类是完全黑盒，也完全不需要知道，只需要使用代理类的增强函数即可
 *      而装饰器模式则不同，装饰器模式是将内部UserDao的实现类给与用户，让用户自己使用增强的装饰器进行嵌套并自我组合使用！
 *      所以装饰器模式下真实业务的生命周期由用户决定，而代理模式中真实业务的生命周期由代理类决定！
 * <p>
 *      3、为什么装饰模式中装饰者父类也要继承真实业务的接口呢？这一点我觉得相当于:给人穿了件衣服[装饰]后的新对象毕竟本质还是人，只是多了件衣服。
 *      所以从面向对象方向思考，我认为装饰者父类应该继承真实业务的接口，虽然不继承也不影响，也可以实现，但那样就有点放飞自我，毕竟DataSourceDecorator装饰器是为了丰满DataSource接口的装饰器！
 * <p>
 * Author: GL
 * Date: 2021-10-29
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException {
        // 获取当前项目路径
        String localPath = Class.forName("org.example.design.structural.decorator.Test").getResource("").getPath();

        // 要写入的原始字符串
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        // 构建加强版输入输出流
        DataSource encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource(String.format("%s/out/OutputDemo.txt", localPath))));
        // 写入顺序：先压缩后加密再写入文件
        encoded.writeData(salaryRecords);

        DataSource plain = new FileDataSource(String.format("%s/out/OutputDemo.txt", localPath));

        System.out.println("- 原始字符串 ----------------");
        System.out.println(salaryRecords);
        System.out.println("- 真是业务流读取文件内字符串 --------------");
        System.out.println(plain.readData());
        System.out.println("- 通过加强版输入输出流读取文件：先读取原始字符串后再解密后再解压缩 --------------");
        System.out.println(encoded.readData());
    }
}
