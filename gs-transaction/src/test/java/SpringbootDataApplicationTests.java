import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tom.demo.Boot;
import com.tom.demo.dto.UserQueryDTO;
import com.tom.demo.repository.UserRepository;
import com.tom.demo.dto.Sex;
import com.tom.demo.dto.Status;
import com.tom.demo.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/9
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Boot.class})
@Slf4j
public class SpringbootDataApplicationTests {
    @Resource
    UserRepository userRepository;

    @Test
    public void loadContext() {
        User user = new User(5l, "tom", "123", Sex.BOY, 18, LocalDateTime.parse("2019-12-03T10:15:30"), Status.UNLOCK);
        int count = userRepository.saveUser(user);
        assertThat(count).as("save user").isEqualTo(1);
        List<User> users = Arrays.asList(new User[]{new User(6l, "tom", "123", Sex.BOY, 18, LocalDateTime.parse("2019-12-03T10:15:30"), Status.UNLOCK),
                new User(7l, "tom", "123", Sex.BOY, 18, LocalDateTime.parse("2019-12-03T10:15:30"), Status.UNLOCK)});
        count = userRepository.saveUserList(users);
        assertThat(count).as("save user").isEqualTo(2);
        userRepository.updateUser(user);

        //软删除
        userRepository.remove(5l, Status.DELETE);
        //硬删除
        userRepository.delete(1l);
        User user1 = userRepository.get(2l);
        log.info("{}", JSON.toJSONString(user1, true));

        //分页并查询
        Page<User> pageInfo = PageHelper.startPage(0, 5);
        List<User> users2 = userRepository.listUser();
        //  log.info("{}", JSON.toJSONString(users2, true));
        //获取分页信息演示, 实际项目中一般会封装为自己的返回体。
        int pageNum = pageInfo.getPageNum();
        int pageSize = pageInfo.getPageSize();
        long total = pageInfo.getTotal();
        List<User> result = pageInfo.getResult();//和上面的users结果相同

        log.info("{}", JSON.toJSONString(pageInfo, true));

        List<User> users3 = userRepository.listUserByIds(Arrays.asList(new Long[]{5l, 4l, 3l, 2l}));
        log.info("{}", JSON.toJSONString(users3, true));
        UserQueryDTO userQueryDTO = new UserQueryDTO();
        userQueryDTO.setNickName("tom");
        List<User> users4 = userRepository.queryByCondition(userQueryDTO);
        log.info("{}", JSON.toJSONString(users4, true));

        List<User> users5= userRepository.getByOrderCondition(18, Sex.BOY);
        log.info("{}", JSON.toJSONString(users5, true));
    }

}