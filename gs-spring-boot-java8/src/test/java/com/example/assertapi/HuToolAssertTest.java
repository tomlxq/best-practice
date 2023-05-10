package com.example.assertapi;


import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.security.KeyPair;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * HutoolAssert
 * 是一些比较常见的工具示例，Hutool还支持非常丰富的工具类，详情可见官方文档：https://hutool.cn/docs
 *
 * @author TomLuo
 * @date 2023年04月26日 21:58
 */
public class HuToolAssertTest {
    /**
     * //判断字符串是否为空
     */
    @Test()
    void isEmpty() {

        String str = null;

        Assert.isTrue(StrUtil.isEmpty(str)); // true

        assertThrows(IllegalArgumentException.class, () -> {
            Assert.isTrue(StrUtil.isNotEmpty(str)); // false
        });
    }

    /**
     * 字符串格式化
     */
    @Test
    void format() {
        String name = "Java";
        String message = StrUtil.format("hello, {}", name);
        Assert.isTrue(message.equals("hello, Java"));
    }


    /**
     * 去除空格和回车
     */
    @Test
    void cleanBlank() {
        String str = "  hello \n world  \n";
        String result = StrUtil.cleanBlank(str);
        Assert.isTrue(result.equals("helloworld"));

        // 去除字符串两端空格
        String trimStr = StrUtil.trim(str);
    }


    /**
     * 字符串替换
     */
    @Test
    void replace() {
        String str = "hello, hutool";
        String result = StrUtil.replace(str, "hutool", "Java");
        Assert.isTrue(result.equals("hello, Java"));
    }


    /**
     * 正则表达式 ReUtil
     */
    @Test
    void reUtil() {
        // 提取字符串中的数字
        String result = ReUtil.get("\\d+", "Hello 123 World", 0); // result = "123"

        // 判断字符串是否匹配正则表达式
        boolean isMatch = ReUtil.isMatch("ab.*cd", "abxxxxxcd");

        // 替换字符串中的匹配项
        String replace = ReUtil.replaceAll("a(.)", "$1#", "abc"); // replace = "b#c"
    }

    /**
     * 合工具集合工具 Hutool的集合ListUtil 工具类提供了非常丰富的方法，可以方便地进行集合操作：
     */

    @Test
    void listUtil() {
        //初始化列表
        List<String> list = ListUtil.of("a", "b", "c");
        System.out.println(list);
        //集合排序
        List<String> list2 = ListUtil.of("b", "a", "c");
        List<String> sortedList = ListUtil.sort(list2, (a, b) -> a.compareTo(b));
        System.out.println(sortedList);
        //集合去重
//        List<String> list3 = ListUtil.of("a", "b", "a", "c");
//        List<String> uniqueList = ListUtil.distinct(list3);
//        System.out.println(uniqueList);
        //集合分组
//        List<String> list4 = ListUtil.of("apple", "banana", "orange", "pear", "peach");
//        Map<Integer, List<String>> groupMap = ListUtil.groupBy(list4, s -> s.length());
//        System.out.println(groupMap);
        //Hutool的集合ListUtil 工具类提供了非常丰富的方法，可以方便地进行集合操作：

        // 初始化列表
        List<String> list5 = ListUtil.of("a", "b", "c");
        System.out.println(list5);


    }

    @Test
    void fileUtil() {
        //创建文件和目录
        File file = FileUtil.touch("example.txt");
        FileUtil.mkdir("exampleDir");
        //删除文件和目录
        FileUtil.del("example.txt");
        FileUtil.del("exampleDir");
        // 复制文件和目录
        FileUtil.copy("source.txt", "target.txt", true); // true表示覆盖
        FileUtil.copy("sourceDir", "targetDir", true);


    }

    @Test
    void jsonUtil() {
        //JSON工具
        // Hutool的 JSONUtil 工具类提供了方便的JSON解析和生成方法：

        //解析JSON字符串
        String jsonStr = "{\"name\":\"hutool\",\"age\":18}";
        JSONObject json = JSONUtil.parseObj(jsonStr);
        String name = json.getStr("name"); // hutool
        int age = json.getInt("age"); // 18
        //生成JSON字符串
        JSONObject json2 = JSONUtil.createObj()
                .set("name", "hutool")
                .set("age", 18);
        String jsonStr2 = json2.toString();
        System.out.println(jsonStr); // {"name":"hutool","age":18}
        // 从JSON字符串中提取节点
        String jsonStr3 = "{\"name\":\"hutool\",\"age\":18}";
        String name3 = JSONUtil.parseObj(jsonStr).getByPath("name").toString();
        int age3 = Integer.parseInt(JSONUtil.parseObj(jsonStr).getByPath("age").toString());
    }


    /**
     * HTTP工具
     * Hutool的 HttpUtil 工具类提供了方便的HTTP请求和响应方法，几行代码就能完成网络请求，文件下载：
     */
    @Test
    void httpUtil() {
        // 发送HTTP GET请求
        HttpResponse response = HttpUtil.createGet("https://www.baidu.com/").execute();
        String body = response.body();
        System.out.println(body);
        //  发送HTTP POST请求
        Map<String, Object> params = new HashMap<>();
        params.put("name", "hutool");
        params.put("age", 18);
        HttpResponse response2 = HttpUtil.createPost("https://example.com/").form(params).execute();
        String body2 = response2.body();
        System.out.println(body2);
        //下载网络文件
        HttpUtil.downloadFile("https://example.com/image.png", FileUtil.file("image.png"));
    }


    /**
     * 日期工具
     * Hutool 处理日期的 DateUtil 工具类能非常方便的帮我们做日期、时间的格式化：
     */
    @Test
    void dateUtil() {
        //格式化日期为字符串
        Date date = new Date();
        String dateString = DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
        System.out.println(dateString);
        //解析字符串为日期
        String dateString2 = "2023-04-23";
        Date date2 = DateUtil.parse(dateString2);
        System.out.println(date2);
        //获取两个日期之间的天数
        String date1 = "2021-01-01";
        String date3 = "2023-04-23";
        long betweenDays = DateUtil.between(DateUtil.parse(date1), DateUtil.parse(date3), DateUnit.DAY);
        System.out.println(betweenDays);
    }


    /**
     * 加解密工具
     * Hutool的加解密 SecureUtil 工具类提供了常用的加密和解密算法，以下是一些常用的示例：
     */
    @Test
    void codeUtil() {
        //MD5加密
        String str = "Java";
        String md5Hex = SecureUtil.md5(str);
        System.out.println(md5Hex);
        //SHA加密
        String str2 = "Java";
        String sha256Hex = SecureUtil.sha256(str2);
        System.out.println(sha256Hex);
        //DES加解密
        String str3 = "Java";
        SymmetricCrypto des = SecureUtil.des();
        String encryptHex = des.encryptHex(str3);
        System.out.println(encryptHex);
        String decryptStr = des.decryptStr(encryptHex);
        System.out.println(decryptStr);
        //AES加解密
        String str4 = "Java";
        SymmetricCrypto aes = SecureUtil.aes();
        String encryptHex4 = aes.encryptHex(str4);
        System.out.println(encryptHex4);
        String decryptStr4 = aes.decryptStr(encryptHex4);
        System.out.println(decryptStr4);
        //RSA加解密
        String str5 = "Java";
        KeyPair pair = SecureUtil.generateKeyPair("RSA");
        RSA rsa = SecureUtil.rsa(pair.getPrivate().getEncoded(), pair.getPublic().getEncoded());
        String encryptBase64 = rsa.encryptBase64(str5, KeyType.PublicKey);
        System.out.println(encryptBase64);
        String decryptStr5 = rsa.decryptStr(encryptBase64, KeyType.PrivateKey);
        System.out.println(decryptStr5);
    }

}