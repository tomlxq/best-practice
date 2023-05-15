package com.guide.example.web;

import com.guide.example.service.TtlProductInfoService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * xxx
 *
 * @author TomLuo
 * @date 2023年05月16日 1:11
 */
@RestController
@RequestMapping("/excelUtils")
public class ExportController {

    @Autowired
    private TtlProductInfoService productInfoService;

    @GetMapping("/export")
    public void export(HttpServletResponse response) {
        this.productInfoService.export(response, "商品信息" + new Random().nextInt(1000));
    }


}