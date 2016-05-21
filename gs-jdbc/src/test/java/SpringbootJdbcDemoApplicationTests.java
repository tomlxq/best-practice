import com.example.SpringBootJdbcDemoApplication;
import com.example.domain.User;
import com.example.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by tom on 2016/5/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootJdbcDemoApplication.class)
public class SpringBootJdbcDemoApplicationTests
{
     Logger logger= LoggerFactory.getLogger(SpringBootJdbcDemoApplicationTests.class);
    @Autowired
    private UserRepository userRepository;

    @Test public void testAll(){
        findAllUsers();
        findUserById();
        createUser();
    }

    @Test
    public void findAllUsers()  {
        List<User> users = userRepository.findAll();
        assertNotNull(users);
        assertTrue(!users.isEmpty());

    }

    @Test
    public void findUserById()  {
        User user = userRepository.findUserById(1);
        assertNotNull(user);
    }
    private void updateById(Integer id)  {
        User newUser = new User(id, "JackChen", "JackChen@qq.com");
        userRepository.update(newUser);
        User newUser2 = userRepository.findUserById(newUser.getId());
        assertEquals(newUser.getName(), newUser2.getName());
        assertEquals(newUser.getEmail(), newUser2.getEmail());
    }
    @Test
    public void createUser() {
        User user = new User(0, "tom", "tom@gmail.com");
        User savedUser = userRepository.create(user);
        logger.debug("{}",savedUser);
        User newUser = userRepository.findUserById(savedUser.getId());
        assertEquals("tom", newUser.getName());
        assertEquals("tom@gmail.com", newUser.getEmail());
        updateById(newUser.getId());
        userRepository.delete(newUser.getId());
    }
}
