import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * www
 *
 * @author TomLuo
 * @date 2023年05月09日 6:03
 */
//EnableLeafServer 开启leafserver
@SpringBootApplication
//@EnableLeafServer
public class LeafdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeafdemoApplication.class, args);
    }
}