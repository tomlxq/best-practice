import com.example.principle.dip.face.Driver;
import com.example.principle.dip.face.ICar;
import com.example.principle.dip.face.IDriver;
import junit.framework.TestCase;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public class DriverTest extends TestCase {
    Mockery context = new JUnit4Mockery();

    @Test
    public void testDriver() {
//根据接口虚拟一个对象
        final ICar car = context.mock(ICar.class);
        IDriver driver = new Driver();
//内部类
        context.checking(new Expectations() {{
            oneOf(car).run();
        }});
        driver.drive(car);
    }
}
