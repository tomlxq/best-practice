package com.example.demo.proxy.jdk.manual;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/18
 */
public class TomProxy {
    public static final String LN = "\r\n";
    protected TomInvocationHandler h;

    public static Object newProxyInstance(TomClassLoader loader,
                                          Class<?>[] interfaces,
                                          TomInvocationHandler h) {
        //1.生成源代码
        String codes = generateCodes(interfaces[0]);
        //2.将生成的源代码保存到磁盘$Proxy0.java
        String path = TomProxy.class.getResource("").getPath();
        File f = new File(path + "$Proxy0.java");
        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
            fw.write(codes);
            fw.flush();
            fw.close();
            fw.close();

            //编译源代码生成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();
            //.class动态加载到JVM
            //返回被代理后的代理对
            Class<?> aClass = loader.findClass("$Proxy0");
            Constructor<?> constructor = aClass.getConstructor(TomInvocationHandler.class);
            return constructor.newInstance(h);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateCodes(Class<?> anInterface) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("package com.example.demo.proxy.jdk.manual;" + LN);
        stringBuffer.append("import java.lang.reflect.Method;" + LN);
        stringBuffer.append("public final class $Proxy0 implements " + anInterface.getName() + " {" + LN);
        stringBuffer.append("TomInvocationHandler h;" + LN);
        stringBuffer.append(" public $Proxy0(TomInvocationHandler h)  {\n" + LN +
                "        this.h=h;\n" + LN +
                "    }" + LN);
        for (Method m : anInterface.getMethods()) {
            stringBuffer.append("@Override" + LN);
            stringBuffer.append("public final " + m.getReturnType().getName() + " " + m.getName() + "()  {" + LN);
            stringBuffer.append("try{" + LN);
            stringBuffer.append(" Method m=" + anInterface.getName() + ".class.getMethod(\"" + m.getName() + "\");" + LN);
            stringBuffer.append(" this.h.invoke(this, m, (Object[])null);" + LN);
            stringBuffer.append("}catch(Throwable e){e.printStackTrace();}" + LN);
            stringBuffer.append("}" + LN);
        }
        stringBuffer.append("}" + LN);

        return stringBuffer.toString();
    }
}
