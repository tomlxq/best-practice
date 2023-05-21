package com.example.refactor.functional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * qqq
 *
 * @author TomLuo
 * @date 2023年05月21日 23:36
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class FtpOperationTemplate {

    private final FTPClient ftpClient;

    public <K> K execute(FtpOperation<FTPClient, K> ftpOperation) {
        try {
            ftpClient.connect("host", 22);
            ftpClient.login("username", "password");
            return ftpOperation.apply(ftpClient);
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