package com.example.refactor.template;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * www
 *
 * @author TomLuo
 * @date 2023年05月21日 23:39
 */
@Slf4j
@Service
public class FtpOperationListDirectories extends FtpOperationTemplate<String, FTPFile[]> {

    @Override
    protected FTPFile[] command(FTPClient ftpClient, String input) throws IOException {
        return ftpClient.listDirectories(input);
    }
}