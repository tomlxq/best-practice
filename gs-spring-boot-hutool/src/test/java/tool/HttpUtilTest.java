package tool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * HTTP 请求工具类
 * 针对最为常用的 GET 和 POST 请求，HttpUtil 封装了两个方法，
 *
 * HttpUtil.get
 * HttpUtil.post
 *
 * @author TomLuo
 * @date 2023年04月18日 5:58
 */
public class HttpUtilTest {
    @Test
    public void getTest() {
        // 最简单的HTTP请求，可以自动通过header等信息判断编码，不区分HTTP和HTTPS
        String result1 = HttpUtil.get("https://www.baidu.com");

// 当无法识别页面编码的时候，可以自定义请求页面的编码
        String result2 = HttpUtil.get("https://www.baidu.com", CharsetUtil.CHARSET_UTF_8);

//可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("city", "北京");

        String result3 = HttpUtil.get("https://www.baidu.com", paramMap);
    }

    @Test
    public void postTest() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("city", "北京");

        String result = HttpUtil.post("https://www.baidu.com", paramMap);
    }

    @Test
    public void uploadTest() {
        HashMap<String, Object> paramMap = new HashMap<>();
//文件上传只需将参数中的键指定（默认file），值设为文件对象即可，对于使用者来说，文件上传与普通表单提交并无区别
        paramMap.put("file", FileUtil.file("D:\\face.jpg"));

        String result = HttpUtil.post("https://www.baidu.com", paramMap);
    }
}
