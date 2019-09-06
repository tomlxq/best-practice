import com.alibaba.fastjson.JSON;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/31
 */
public class TestBeanDefinition {
    @Test
    public void testSimpleLoad() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:test.xml");
        GenericApplicationContext context2 = new GenericApplicationContext();
        context2.setParent(context);
        context2.registerBean(SubApplicationContext.class);
        context2.refresh();
        TestBean testBean = (TestBean) context.getBean("testBean");
        System.out.printf("test bean: %s", testBean.getTestStr());
    }

    @Test
    public void xsdValidationAutodetect() throws IOException {
        //new ClassPathResource("test.xml").getInputStream();//
        //1. 定位
        InputStream resourceAsStream = getClass().getResourceAsStream("test.xml");
        Resource resource = new InputStreamResource(resourceAsStream);
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
        xmlBeanDefinitionReader.setValidationMode(0);
        //2. 载入 3. 注册
        xmlBeanDefinitionReader.loadBeanDefinitions(resource);
        TestBean bean = (TestBean) factory.getBean("testBean");
        System.out.println(JSON.toJSONString(bean, true));


    }
}
