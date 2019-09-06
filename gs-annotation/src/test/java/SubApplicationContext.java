import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/31
 */
public class SubApplicationContext implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("hello sub ApplicationContext");
    }
}
