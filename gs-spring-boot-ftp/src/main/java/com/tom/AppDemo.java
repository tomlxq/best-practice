package com.tom;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * AppDemo 使用 SpringBoot 配置 FTP 服务器，上传、删除、下载文件
 * install Vsftpd in centos:
 * rpm -qa | grep vsftpd
 * yum -y install vsftpd
 * vim /etc/vsftpd/vsftpd.conf
 * vi /etc/vsftpd/vsftpd.conf
 * systemctl start vsftpd.service
 * systemctl status vsftpd.service
 * adduser ftpadmin
 * passwd ftpadmin
 * mkdir /app/upload
 * mkdir -f /app/upload
 * mkdir -p /app/upload
 * chmod 777 /app/upload/
 *
 * @author TomLuo
 * @date 2023年04月19日 6:26
 */
@SpringBootApplication
@Slf4j
public class AppDemo {
    public static void main(String[] args) {
        SpringApplication.run(AppDemo.class, args);
    }


}