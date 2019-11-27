import com.tom.demo.jdbc.annotation.AppConfig;
import com.tom.demo.jdbc.annotation.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/24
 */
@ContextConfiguration(classes = AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceAnnotationTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testTransfer() {

        try {
            accountService.transfer("aaa", "bbb", 500);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
