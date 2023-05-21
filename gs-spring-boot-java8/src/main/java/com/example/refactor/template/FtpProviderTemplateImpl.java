package com.example.refactor.template;

import com.example.refactor.FtpProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.stereotype.Service;

/**
 * www
 *
 * @author TomLuo
 * @date 2023年05月21日 23:40
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class FtpProviderTemplateImpl implements FtpProvider {

    private final FtpOperationTemplate<String, FTPFile[]> ftpOperationListDirectories;
    private final FtpOperationTemplate<String, Boolean> ftpOperationDeleteFile;
    private final FTPClient ftpClient;

    public FTPFile[] listDirectories(String parentDirectory) {
        return ftpOperationListDirectories.execute(ftpClient, parentDirectory);
    }

    public boolean deleteFile(String filePath) {
        return ftpOperationDeleteFile.execute(ftpClient, filePath);
    }
}