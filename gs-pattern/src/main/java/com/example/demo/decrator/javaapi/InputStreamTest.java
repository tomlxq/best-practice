package com.example.demo.decrator.javaapi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public class InputStreamTest {
    public static void main(String[] args) throws IOException {
        String path = InputStreamTest.class.getResource("/").getPath();
        InputStream file = new FileInputStream(new File(path + "/test.txt"));
        file = new UpperInputStream(file);
        int c;
        while ((c = file.read()) != -1) {
            System.out.print((char) c);
        }
    }
}
