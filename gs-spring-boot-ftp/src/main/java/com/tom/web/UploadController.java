package com.tom.web;


import com.tom.entity.UploadVo;
import com.tom.service.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * UploadController
 *
 * @author TomLuo
 * @date 2023年04月19日 23:46
 */
@Slf4j
@RestController
@RequestMapping("/upload")
@Api(value = "upload", tags = "上传文件")
@RequiredArgsConstructor
public class UploadController {
    final private UploadService uploadService;

    @ApiOperation(value = "上传图片", notes = "上传图片")
    @PostMapping("/uploadImage")
    public UploadVo uploadImage(@RequestParam("file") MultipartFile file) {
        return uploadService.uploadImage(file);
    }

    @ApiOperation(value = "删除文件", notes = "删除文件")
    @GetMapping("/delFile")
    public Boolean delFile(String fileName) {
        return uploadService.delFile(fileName);
    }

    @ApiOperation(value = "下载文件", notes = "下载文件")
    @GetMapping("/downloadFile")
    public Boolean downloadFile(String fileName, String downloadPath) {
        return uploadService.downloadFile(fileName, downloadPath);
    }

}