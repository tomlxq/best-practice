import com.tom.demo.dto.Foo;
import com.tom.demo.service.FooService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/8
 */
@ContextConfiguration(locations = {"classpath*:context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestTransaction {
    @Autowired
    FooService fooService;
    @Test
    public void testTrans(){
       // ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml",TestTransaction.class);
      //  FooService fooService = (FooService) ctx.getBean("fooService");
        fooService.insertFoo (new Foo());
    }
}
