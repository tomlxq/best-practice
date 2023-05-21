package com.example.refactor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;

/**
 * xxx
 *
 * @author TomLuo
 * @date 2023年05月21日 23:19
 */
@Slf4j
public class FtpProviderDraw {

    private final FTPClient ftpClient;

    public FtpProviderDraw(FTPClient ftpClient) {
        this.ftpClient = ftpClient;
    }

    public FTPFile[] listDirectories(String parentDirectory) {
        try {
            ftpClient.connect("host", 22);
            ftpClient.login("username", "password");
            return ftpClient.listDirectories(parentDirectory);
        } catch (IOException ex) {
            log.error("Something went wrong", ex);
            throw new RuntimeException(ex);
        } finally {
            try {
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException ex) {
                log.error("Something went wrong while finally", ex);
            }
        }
    }

    public boolean deleteFile(String filePath) {
        try {
            ftpClient.connect("host", 22);
            ftpClient.login("username", "password");
            return ftpClient.deleteFile(filePath);
        } catch (IOException ex) {
            log.error("Something went wrong", ex);
            throw new RuntimeException(ex);
        } finally {
            try {
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException ex) {
                log.error("Something went wrong while finally", ex);
            }
        }
    }
}