/**
 * www
 *
 * @author TomLuo
 * @date 2023年03月01日 20:29
 */

import com.baomidou.mybatisplus.core.toolkit.AES;
import org.junit.jupiter.api.Test;

public  class AESTest {
    @Test
    void test01() {
        //生成的十六位随机AES密钥
        //String randomKey = AES.generateRandomKey();
        String randomKey = "bd8526e2b6b6ace8";
        //使用随机密钥加密需要加密的数据，列如数据库url,username,password
        String url = "jdbc:mysql://192.168.238.150:3306/demo?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "root";
        String aesUrl = AES.encrypt(url, randomKey);
        String aesUsername = AES.encrypt(username, randomKey);
        String aesPassword = AES.encrypt(password, randomKey);
        System.out.println("url:" + aesUrl);
        System.out.println("username:" + aesUsername);
        System.out.println("password:" + aesPassword);
    }
}