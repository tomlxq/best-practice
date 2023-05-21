package com.example.refactor;

import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;

/**
 * qq
 *
 * @author TomLuo
 * @date 2023年05月21日 23:27
 */
public interface FtpProvider {

    FTPFile[] listDirectories(String directory) throws IOException;

    boolean deleteFile(String filePath) throws IOException;
}