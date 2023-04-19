package com.tom.service;

import com.tom.entity.UploadVo;
import org.springframework.web.multipart.MultipartFile;

/**
 * UploadService
 *
 * @author TomLuo
 * @date 2023年04月19日 23:48
 */
public interface UploadService {
    UploadVo uploadImage(MultipartFile file);

    Boolean delFile(String fileName);

    Boolean downloadFile(String fileName, String downloadPath);
}