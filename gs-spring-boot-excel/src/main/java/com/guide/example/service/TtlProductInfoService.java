package com.guide.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guide.example.entity.TtlProductInfoPo;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

/**
 * xxx
 *
 * @author TomLuo
 * @date 2023年05月16日 1:08
 */
public interface TtlProductInfoService extends IService<TtlProductInfoPo> {
    List<TtlProductInfoPo> listProduct(Map<String, Object> map);

    void export(HttpServletResponse response, String fileName);
}