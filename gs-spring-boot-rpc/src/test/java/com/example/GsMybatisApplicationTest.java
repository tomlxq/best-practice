package com.example;


import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableMap;
import io.github.admin4j.http.HttpRequest;
import io.github.admin4j.http.core.HttpHeaderKey;
import io.github.admin4j.http.core.Pair;
import io.github.admin4j.http.util.HttpJsonUtil;
import io.github.admin4j.http.util.HttpUtil;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * GsMybatisApplicationTest
 *
 * @author TomLuo
 * @date 2023年06月04日 16:46
 */
class GsMybatisApplicationTest {
    @Test
    void get() {
        Response response = HttpUtil.get("https://github.com/search", Pair.of("q", "okhttp"));
        System.out.println("response = " + response);


    }

    @Test
    void post() {
        // JSON 格式的body
        Response post = HttpUtil.post("https://oapi.dingtalk.com/robot/send?access_token=27f5954ab60ea8b2e431ae9101b1289c138e85aa6eb6e3940c35ee13ff8b6335", "{\"msgtype\": \"text\",\"text\": {\"content\":\"【反馈提醒】我就是我, 是不一样的烟火\"}}");
        System.out.println("post = " + post);

        //form 请求
        Map<String, Object> formParams = ImmutableMap.of("username", "admin", "password", "admin123");
        Response response2 = HttpUtil.postForm("https://github.com/auth/login", formParams);
        System.out.println("response = " + response2);

        // 返回格式为JSON的 可以使用 HttpJsonUtil 自动返回JsonObject

        JSONObject object = HttpJsonUtil.get("https://github.com/search",
                Pair.of("q", "http"),
                Pair.of("username", "agonie201218"));
        System.out.println("object = " + object);
    }

    /**
     * 文件上传
     */
    @Test
    void upload() throws UnsupportedEncodingException {
        String path = this.getClass().getResource("/").getPath() + URLEncoder.encode("一行代码搞定Http请求？强得离谱~.pdf", "UTF-8");
        File file = new File(path);
        ;//App传递给后台时候编码
        //  URLDecoder.decode(ss,"UTF-8");//后台接到时候进行转码
        Map<String, Object> formParams = ImmutableMap.of(
                "key", "test", "file", file, "token", "WXyUseb-D4sCum-EvTIDYL-mEehwDtrSBg-Zca7t:qgOcR2gUoKmxt-VnsNb657Oatzo=:eyJzY29wZSI6InpoYW56aGkiLCJkZWFkbGluZSI6MTY2NTMwNzUxNH0=");
        Response response = HttpUtil.upload("https://upload.qiniup.com/", formParams);
        System.out.println(response);
    }

    @Test
    void down() throws IOException {
        HttpUtil.down("https://gitee.com/admin4j/common-http", this.getClass().getResource("/").getPath());
    }


    /**
     * HttpRequest 链式请求
     *
     * @throws UnsupportedEncodingException
     */
    @Test
    void req() throws UnsupportedEncodingException {
//get
        Response response = HttpRequest.get("https://search.gitee.com/?skin=rec&type=repository")
                .queryMap("q", "admin4j")
                .header(HttpHeaderKey.USER_AGENT, "admin4j")
                .execute();
        System.out.println("response = " + response);

        // post form
        Response response2 = HttpRequest.get("http://search.gitee.com/auth/login")
                .queryMap("q", "admin4j")
                .header(HttpHeaderKey.USER_AGENT, "admin4j")
                .form("username", "admin")
                .form("password", "admin123")
                .execute();
        System.out.println("response = " + response2);
    }
}