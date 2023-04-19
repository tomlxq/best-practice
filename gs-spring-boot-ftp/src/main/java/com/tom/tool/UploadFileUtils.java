package com.tom.tool;
import com.jcraft.jsch.*;

import com.tom.entity.UploadFileDto;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;
/**
 * xxxx
 *
 * @author TomLuo
 * @date 2023年04月19日 23:38
 */
@Slf4j
public class UploadFileUtils {

    /**
     * @MonthName： upload
     * @Description： 上传文件
     * @Author： tanyp
     * @Date： 2022/12/19 10:38
     * @Param： [dto]
     * @return： boolean
     **/
    public static boolean upload(UploadFileDto dto) throws Exception {
        log.info("============上传文件开始==============");
        Boolean result = false;
        ChannelSftp sftp = null;
        Channel channel = null;
        Session sshSession = null;
        try {
            JSch jSch = new JSch();
            jSch.getSession(dto.getAccount(), dto.getHost(), dto.getPort());
            sshSession = jSch.getSession(dto.getAccount(), dto.getHost(), dto.getPort());
            sshSession.setPassword(dto.getPasswd());
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            channel = sshSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;

            sftp.cd(dto.getWorkingDir());
            sftp.put(dto.getInputStream(), dto.getFileName());
            result = true;
            log.info("============上传文件结束==============");
        } catch (JSchException e) {
            result = false;
            log.error("=====上传文件异常:{}", e.getMessage());
            e.printStackTrace();
        } finally {
            closeChannel(sftp);
            closeChannel(channel);
            closeSession(sshSession);
        }
        return result;
    }

    /**
     * @MonthName： delete
     * @Description： 删除文件
     * @Author： tanyp
     * @Date： 2022/12/19 10:38
     * @Param： [dto]
     * @return： boolean
     **/
    public static boolean delete(UploadFileDto dto) throws Exception {
        log.info("============删除文件开始==============");
        Boolean result = false;
        ChannelSftp sftp = null;
        Channel channel = null;
        Session sshSession = null;
        try {
            JSch jSch = new JSch();
            jSch.getSession(dto.getAccount(), dto.getHost(), dto.getPort());
            sshSession = jSch.getSession(dto.getAccount(), dto.getHost(), dto.getPort());
            sshSession.setPassword(dto.getPasswd());
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            channel = sshSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;

            sftp.cd(dto.getWorkingDir());
            sftp.rm(dto.getFileName());
            result = true;
            log.info("============删除文件结束==============");
        } catch (JSchException e) {
            result = false;
            log.error("=====删除文件异常:{}", e.getMessage());
            e.printStackTrace();
        } finally {
            closeChannel(sftp);
            closeChannel(channel);
            closeSession(sshSession);
        }
        return result;
    }

    /**
     * @MonthName： download
     * @Description： 下载文件
     * @Author： tanyp
     * @Date： 2022/12/19 10:38
     * @Param： [dto]
     * @return： boolean
     **/
    public static boolean download(UploadFileDto dto) throws Exception {
        log.info("============下载文件开始==============");
        Boolean result = false;
        ChannelSftp sftp = null;
        Channel channel = null;
        Session sshSession = null;
        try {
            JSch jSch = new JSch();
            jSch.getSession(dto.getAccount(), dto.getHost(), dto.getPort());
            sshSession = jSch.getSession(dto.getAccount(), dto.getHost(), dto.getPort());
            sshSession.setPassword(dto.getPasswd());
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            channel = sshSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;

            sftp.cd(dto.getWorkingDir());
            sftp.get(dto.getFileName(), new FileOutputStream(new File(dto.getDownloadPath())));
            sftp.disconnect();
            sftp.getSession().disconnect();
            result = true;
            log.info("============下载文件结束==============");
        } catch (JSchException e) {
            result = false;
            log.error("=====下载文件异常:{}", e.getMessage());
            e.printStackTrace();
        } finally {
            closeChannel(sftp);
            closeChannel(channel);
            closeSession(sshSession);
        }
        return result;
    }

    private static void closeChannel(Channel channel) {
        if (channel != null) {
            if (channel.isConnected()) {
                channel.disconnect();
            }
        }
    }

    private static void closeSession(Session session) {
        if (session != null) {
            if (session.isConnected()) {
                session.disconnect();
            }
        }
    }

}