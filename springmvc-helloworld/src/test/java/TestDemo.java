import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class TestDemo {

    private static final String PACKAGE_PATH = "";
    private static final String NONEXISTENT_RESOURCE_NAME = "example.xml";
    private static final String FQ_RESOURCE_PATH = PACKAGE_PATH + '/' + NONEXISTENT_RESOURCE_NAME;
    private static final String FQ_RESOURCE_PATH_WITH_LEADING_SLASH = '/' + FQ_RESOURCE_PATH;
    @Test
    public void test(){
        //BeanDefinition的resource定位
        ClassPathResource resource = new ClassPathResource(FQ_RESOURCE_PATH);
        DefaultListableBeanFactory registry = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        reader.setValidationMode(XmlBeanDefinitionReader.VALIDATION_DTD);
        //载入\注册，以后就可以从registry.getBean()拿来使用了
        reader.loadBeanDefinitions(resource);

    }
}