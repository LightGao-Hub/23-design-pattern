package org.example.design.structural.decorator;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 *  真是业务类-FileDataSource，实现DataSource接口，提供真正读取文件和写入文件的能力
 *
 * Author: GL
 * Date: 2021-10-30
 */
public class FileDataSource implements DataSource {

    private final String name;

    public FileDataSource(String name) {
        this.name = name;
    }

    @Override
    public void writeData(String data) {
        File file = new File(name);
        file.deleteOnExit();
        try {
            FileUtils.writeByteArrayToFile(file, data.getBytes());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String readData() {
        String buffer = null;
        try {
            buffer = FileUtils.readFileToString(new File(name), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        assert buffer != null;
        return buffer;
    }
}
