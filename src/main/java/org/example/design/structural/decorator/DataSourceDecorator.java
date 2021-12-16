package org.example.design.structural.decorator;

import lombok.Getter;

/**
 *  此类为装饰器模型父类，同样实现DataSource接口，因为此装饰器最终是为真实业务DataSource提供的装饰，从面向对象角度思考应该继承
 *
 *  同理可看FilterInputStream类，此类就是InputStream的装饰类
 *
 * Author: GL
 * Date: 2021-10-30
 */
public abstract class DataSourceDecorator implements DataSource {
    @Getter
    protected final DataSource wrapper;

    DataSourceDecorator(DataSource source) {
        this.wrapper = source;
    }

}
