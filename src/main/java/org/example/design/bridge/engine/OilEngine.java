package org.example.design.bridge.engine;

/**
 *  汽油引擎
 * Author: GL
 * Date: 2021-10-28
 */
public class OilEngine implements Engine {
    @Override
    public void start() {
        System.out.println(" 启动汽油引擎... ");
    }
}
