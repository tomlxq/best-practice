package com.example.data.masking.controller;

import com.example.data.masking.entity.TestAnnotationDTO;
import com.example.data.masking.entity.TestDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: xx
 * @Author: TomLuo
 * @CreateDate: 2023年06月18日 11:30
 * @Version: V1.0
 */

@RestController
@RequestMapping("/test")
public class TestApi {

    @GetMapping("/test")
    public TestDTO test(){
        TestDTO testDTO = new TestDTO();
        testDTO.setPhone("17677772345");
        return testDTO;
    }
    @GetMapping("/test-annotation")
    public TestAnnotationDTO testAnnotation(){
        TestAnnotationDTO testAnnotationDTO = new TestAnnotationDTO();
        testAnnotationDTO.setPhone("17677772345");
        testAnnotationDTO.setCustom("111111111111111111");
        testAnnotationDTO.setEmail("1433926101@qq.com");
        testAnnotationDTO.setIdCard("4444199810015555");
        return testAnnotationDTO;
    }
}