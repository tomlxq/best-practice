import com.tom.entities.User;
import com.tom.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by tom on 2016/6/1.
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void findAllUsers()  {
        List<User> users = userService.findAll();
        assertNotNull(users);
        assertTrue(!users.isEmpty());
    }

    @Test
    public void findUserById()  {
        User user = userService.findUserById(1);
        assertNotNull(user);
    }

    @Test
    public void createUser() {
        User user = new User(0, "tom", "tom@gmail.com", "tom", null);
        User savedUser = userService.create(user);
        User newUser = userService.findUserById(savedUser.getId());
        assertEquals("tom", newUser.getName());
        assertEquals("tom@gmail.com", newUser.getEmail());
    }


}
