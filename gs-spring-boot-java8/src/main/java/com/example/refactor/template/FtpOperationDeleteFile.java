package com.example.refactor.template;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * wwww
 *
 * @author TomLuo
 * @date 2023年05月21日 23:39
 */
@Slf4j
@Service
public class FtpOperationDeleteFile extends FtpOperationTemplate<String, Boolean> {

    @Override
    protected Boolean command(FTPClient ftpClient, String input) throws IOException {
        return ftpClient.deleteFile(input);
    }
}