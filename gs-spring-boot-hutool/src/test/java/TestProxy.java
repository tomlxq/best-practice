import com.example.demo.proxy.jdk.Person;
import com.example.demo.proxy.jdk.TomPerson;
import com.example.demo.proxy.manual.TomMatchmaker;
import org.junit.Test;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/18
 */
public class TestProxy {
    @Test
    public void testProxy(){
        Person p3 = (Person) new TomMatchmaker().getInstance(new TomPerson());
        System.out.println(p3.getClass());
        p3.findLove();
    }
}
