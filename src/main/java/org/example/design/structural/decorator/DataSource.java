package org.example.design.structural.decorator;

/**
 *  真是业务类的顶级接口，定义真是业务类必须实现的函数
 *
 * Author: GL
 * Date: 2021-10-30
 */
public interface DataSource {

    void writeData(String data);

    String readData();
}
