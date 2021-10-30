package org.example.design.structural.decorator;

import java.util.Base64;

/**
 *  加密装饰器，提供加密和解密能力，注意readData和writeData的实现区别：
 *      writeData是先加密后调用父类写入，readData则是先用父类读取后再解密
 *
 * Author: GL
 * Date: 2021-10-30
 */
public class EncryptionDecorator extends DataSourceDecorator {

    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        super.writeData(encode(data));
    }

    @Override
    public String readData() {
        return decode(super.readData());
    }

    private String encode(String data) {
        byte[] result = data.getBytes();
        for (int i = 0; i < result.length; i++) {
            result[i] += (byte) 1;
        }
        return Base64.getEncoder().encodeToString(result);
    }

    private String decode(String data) {
        byte[] result = Base64.getDecoder().decode(data);
        for (int i = 0; i < result.length; i++) {
            result[i] -= (byte) 1;
        }
        return new String(result);
    }
}
