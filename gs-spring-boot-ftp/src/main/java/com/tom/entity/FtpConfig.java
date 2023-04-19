package com.tom.entity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * eee
 *
 * @author TomLuo
 * @date 2023年04月19日 23:53
 */
@Component
public class FtpConfig {

    // ftp 服务器ip地址
    @Value("${ftp.host}")
    public String host;

    // ftp 服务器port，默认是21
    @Value("${ftp.post}")
    public Integer post;

    // ftp 服务器用户名
    @Value("${ftp.username}")
    public String username;

    // ftp 服务器密码
    @Value("${ftp.password}")
    public String password;

    // ftp 服务器存储图片的绝对路径
    @Value("${ftp.base-path}")
    public String basePath;

    // ftp 服务器外网访问图片路径
    @Value("${ftp.image-base-url}")
    public String imageBaseUrl;

}