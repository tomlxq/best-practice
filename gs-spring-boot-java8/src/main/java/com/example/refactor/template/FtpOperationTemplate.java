package com.example.refactor.template;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 *     模板方法实现
 *
 * 向接口 FtpProvider 添加一个新方法，需要我们在两个地方进行更改。我们需要添加一个新的类，会导致类爆炸，另外，我们还需要将实现注入到 FtpProvider。
 *
 * @author TomLuo
 * @date 2023年05月21日 23:38
 */
@RequiredArgsConstructor
@Slf4j
@Service
public abstract class FtpOperationTemplate<T, K> {

    protected abstract K command(FTPClient ftpClient, T input) throws IOException;

    public K execute(FTPClient ftpClient, T input) {
        try {
            ftpClient.connect("host", 22);
            ftpClient.login("username", "password");
            return command(ftpClient, input);
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