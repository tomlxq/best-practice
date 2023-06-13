package com.example.demo1.service;

import com.example.entity.SkuImagesEntity;

import java.util.List;

/**
 * SkuImagesService
 *
 * @author TomLuo
 * @date 2023年03月12日 22:58
 */
public interface SkuImagesService {
    List<SkuImagesEntity> getImagesBySkuId(Long skuId);
}
