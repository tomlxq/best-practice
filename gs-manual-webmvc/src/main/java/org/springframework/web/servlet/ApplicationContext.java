package org.springframework.web.servlet;


import com.sun.org.apache.xerces.internal.dom.DeferredElementNSImpl;
import org.springframework.web.annotation.Autowired;
import org.springframework.web.annotation.Controller;
import org.springframework.web.annotation.Qualifier;
import org.springframework.web.annotation.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/22
 */
//@Slf4j
public class ApplicationContext {
    private Map<String, Object> iocContainer = new ConcurrentHashMap<String, Object>();

    private List<String> classCache = new ArrayList<String>();



    public ApplicationContext(String contextConfigLocation) {
        try {
            //1. 定位
            InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation.replace("classpath*:", ""));
            //2. 载入
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document expected = documentBuilder.parse(new InputSource(resourceAsStream));
            Element documentElement = expected.getDocumentElement();
            NodeList elementsByTagName = documentElement.getElementsByTagName("context:component-scan");
            Node item = elementsByTagName.item(0);
            String packagePath = ((DeferredElementNSImpl) item).getAttribute("base-package");
            //3. 注册 把所有的class找出来存起来
            doRegister(packagePath);
            //4. 初始化 对有@Controller @Service @Repository的类进行实例化
            doCreateBean();
            //5. 注入 对有@Controller @Service @Repository的实例，里面有@Autowired的变量赋值
            populate();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void populate() {
        if (iocContainer.isEmpty()) {
            return;
        }
        iocContainer.forEach((clazz, object) -> {
            Field[] declaredFields = object.getClass().getDeclaredFields();
            Arrays.stream(declaredFields).forEach(field -> {
                if (!field.isAnnotationPresent(Autowired.class)) {
                    return;
                }
                Qualifier qualifier = field.getAnnotation(Qualifier.class);
                String id= field.getType().getName();
                if(qualifier!=null) {
                     id = qualifier.value();
                }
                System.out.println("注入名称为id："+id);
                field.setAccessible(true);
                try {
                    field.set(object, iocContainer.get(id));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        });
    }

    private String firstLetterLower(String name) {
        char[] chars = name.toCharArray();
        chars[0]+=32;
        return String.valueOf(chars);
    }

    private void doCreateBean() {
        if (classCache.isEmpty()) {
            return;
        }
        classCache.forEach(clazz -> {
            try {
                Class<?> aClass = Class.forName(clazz);
                if (aClass.isAnnotationPresent(Controller.class)) {
                    iocContainer.put(firstLetterLower(aClass.getSimpleName()), aClass.newInstance());
                }
                if (aClass.isAnnotationPresent(Service.class)) {
                    Service service = aClass.getAnnotation(Service.class);
                    String id = service.value();
                    if (!"".equals(id)) {
                        iocContainer.put(id, aClass.newInstance());
                        return;
                    }

                        Class<?>[] interfaces = aClass.getInterfaces();
                        Arrays.stream(interfaces).forEach(subClass -> {
                            try {
                                iocContainer.put(subClass.getName(), aClass.newInstance());
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        });

                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

        });

    }

    private void doRegister(String packagePath) {

        URL url = this.getClass().getClassLoader().getResource( packagePath.replaceAll("\\.", "/"));
        File file = new File(url.getFile());
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                doRegister(packagePath + "." + f.getName());
            } else {
                classCache.add(packagePath + "." + f.getName().replace(".class", ""));
            }
        }
    }

    public Object getBean(String name) {
        return iocContainer.get(name);
    }

    public Map<String, Object> getAll() {
        return iocContainer;
    }
}
