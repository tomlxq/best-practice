import com.tom.entity.User;
import com.tom.entity.UserMemo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * TestForLoop
 *
 * @author TomLuo
 * @date 2023年04月19日 23:15
 */
@Slf4j
public class TestForLoop {
    public static List<User> getUserTestList() {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 50000; i++) {
            User user = new User();
            user.setName(UUID.randomUUID().toString());
            user.setUserId((long) i);
            users.add(user);
        }
        return users;
    }

    public static List<UserMemo> getUserMemoTestList() {
        List<UserMemo> userMemos = new ArrayList<>();
        for (int i = 30000; i >= 1; i--) {
            UserMemo userMemo = new UserMemo();
            userMemo.setContent(UUID.randomUUID().toString());
            userMemo.setUserId((long) i);
            userMemos.add(userMemo);
        }
        return userMemos;
    }

    @Test
    void name() {
        List<User> userTestList = getUserTestList();
        List<UserMemo> userMemoTestList = getUserMemoTestList();


        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (User user : userTestList) {
            Long userId = user.getUserId();
            for (UserMemo userMemo : userMemoTestList) {
                if (userId.equals(userMemo.getUserId())) {
                    String content = userMemo.getContent();
                    log.info("模拟数据content 业务处理......"+content);
                }
            }
        }


        stopWatch.stop();
        log.info("最终耗时"+stopWatch.getTotalTimeMillis());
    }

    @Test
    void name2() {
        List<User> userTestList = getUserTestList();
        List<UserMemo> userMemoTestList = getUserMemoTestList();


        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (User user : userTestList) {
            Long userId = user.getUserId();
            for (UserMemo userMemo : userMemoTestList) {
                if (userId.equals(userMemo.getUserId())) {
                    String content = userMemo.getContent();
                    log.info("模拟数据content 业务处理......"+content);
                    break;
                }
            }
        }


        stopWatch.stop();
        log.info("最终耗时"+stopWatch.getTotalTimeMillis());
    }

    @Test
    void name3() {
        List<User> userTestList = getUserTestList();
        List<UserMemo> userMemoTestList = getUserMemoTestList();


        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Map<Long, String> contentMap =
                userMemoTestList.stream().collect(Collectors.toMap(UserMemo::getUserId, UserMemo::getContent));

        for (User user : userTestList) {
            Long userId = user.getUserId();
            String content = contentMap.get(userId);

            if (StringUtils.hasLength(content)) {
                log.info("模拟数据content 业务处理......" + content);
            }

        }

        stopWatch.stop();
        log.info("最终耗时" + stopWatch.getTotalTimeMillis());
    }
}