package com.example.refactor.functional;

import com.example.refactor.FtpProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.stereotype.Service;

/**
 * @Aspect切面方式实现
 *
 * 向 FtpProvider 接口添加一个新方法，需要我们仅在一个地方进行更改。
 * 我们可以轻松地将我们的 FtpProvider 注入到其他服务中。
 * 此解决方案的强项可能是 @FtpOperation 注释，
 * 它可以在 FtpProvider 上下文实现之外使用，但是将 Ftp 操作的逻辑划分到单独的类中并不是一个好方法。
 *
 * @author TomLuo
 * @date 2023年05月21日 23:37
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class FtpProviderFunctionalInterfaceImpl implements FtpProvider {

    private final FtpOperationTemplate ftpOperationTemplate;

    public FTPFile[] listDirectories(String parentDirectory) {
        return ftpOperationTemplate.execute(ftpClient -> ftpClient.listDirectories(parentDirectory));
    }

    public boolean deleteFile(String filePath) {
        return ftpOperationTemplate.execute(ftpClient -> ftpClient.deleteFile(filePath));
    }
}