import com.tom.demo.service.FooService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/4
 */
@ContextConfiguration(locations = {"classpath*:application.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class LogAspectXmlTest {
    @Autowired
    FooService fooService;

    @Test
    public void testAdd() {
        fooService.add(1);
    }

    @Test
    public void testUpdate() {
        fooService.update();
    }

    @Test
    public void testDel() {
        fooService.del();
    }

    @Test
    public void testQuery() {
        fooService.query();
    }
}
