package com.example.refactor.aspect;

import com.example.refactor.FtpProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * aaa
 *
 * @author TomLuo
 * @date 2023年05月21日 23:29
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FtpProviderImpl implements FtpProvider {

    private final FTPClient ftpClient;

    @Override
    @FtpOperation
    public FTPFile[] listDirectories(String directory) throws IOException {
        return ftpClient.listDirectories(directory);
    }

    @Override
    @FtpOperation
    public boolean deleteFile(String filePath) throws IOException {
        return ftpClient.deleteFile(filePath);
    }
}