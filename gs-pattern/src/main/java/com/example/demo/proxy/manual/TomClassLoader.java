package com.example.demo.proxy.manual;


import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/18
 */
public class TomClassLoader extends java.lang.ClassLoader {
    public static final String PACKAGE_NAME = TomProxy.class.getPackage().getName();
    File baseDir;

    public TomClassLoader() {
        String path = TomClassLoader.class.getResource("").getPath();
        this.baseDir = new File(path);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = PACKAGE_NAME + "." + name;
        if (this.baseDir.exists()) {
            File classFile = new File(this.baseDir, name.replaceAll("\\.", File.separator) + ".class");
            if (classFile.exists()) {
                FileInputStream inputStream = null;
                ByteArrayOutputStream outputStream = null;
                try {
                    inputStream = new FileInputStream(classFile);
                    outputStream = new ByteArrayOutputStream();
                    byte[] buf = new byte[1024];
                    int len;
                    while ((len = inputStream.read(buf)) > 0) {
                        outputStream.write(buf, 0, len);
                    }
                    return defineClass(className, outputStream.toByteArray(), 0, outputStream.size());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly(outputStream);
                }
            }
        }
        return null;
    }
}
