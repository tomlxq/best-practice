package com.example.demo.proxy.jdk.manual;

import java.io.File;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/18
 */
public class TomClassLoader extends java.lang.ClassLoader {
    File baseDir;
    public TomClassLoader(){
        String path = TomClassLoader.class.getResource("").getPath();
        this.baseDir=new File(path);
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className=TomProxy.class.getPackage().getName()+"."+name;

        if(this.baseDir.exists()){
            File classFile = new File(this.baseDir, name.replaceAll("\\.", File.separator));
            if(classFile.exists()){

            }

        }
        return null;
    }
}
