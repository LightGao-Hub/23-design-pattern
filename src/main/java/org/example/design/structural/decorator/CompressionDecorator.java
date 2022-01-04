package org.example.design.structural.decorator;

import static org.example.design.config.FinalConfig.OUTPUT_STREAM_SIZE;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import lombok.Getter;
import lombok.Setter;


/**
 *  压缩装饰器类, 提供压缩和解压缩能力, 注意readData和writeData的实现区别：
 *      writeData是先压缩后调用父类写入, readData则是先用父类读取后再解压缩
 *
 * Author: GL
 * Date: 2021-10-30
 */
public class CompressionDecorator extends DataSourceDecorator {
    @Getter
    @Setter
    private int compLevel = 6;

    public CompressionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        super.getWrapper().writeData(compress(data));
    }

    @Override
    public String readData() {
        return decompress(super.getWrapper().readData());
    }

    private String compress(String stringData) {
        byte[] data = stringData.getBytes();
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream(OUTPUT_STREAM_SIZE);
            DeflaterOutputStream dos = new DeflaterOutputStream(bout, new Deflater(compLevel));
            dos.write(data);
            dos.close();
            bout.close();
            return Base64.getEncoder().encodeToString(bout.toByteArray());
        } catch (IOException ex) {
            return null;
        }
    }

    private String decompress(String stringData) {
        byte[] data = Base64.getDecoder().decode(stringData);
        try {
            InputStream in = new ByteArrayInputStream(data);
            InflaterInputStream iin = new InflaterInputStream(in);
            ByteArrayOutputStream bout = new ByteArrayOutputStream(OUTPUT_STREAM_SIZE);
            int b;
            while ((b = iin.read()) != -1) {
                bout.write(b);
            }
            in.close();
            iin.close();
            bout.close();
            return new String(bout.toByteArray());
        } catch (IOException ex) {
            return null;
        }
    }
}
