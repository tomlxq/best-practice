package com.example.service;

import com.example.entity.SpuInfoDescEntity;

/**
 * SpuInfoDescService
 *
 * @author TomLuo
 * @date 2023年03月12日 23:00
 */
public interface SpuInfoDescService {
    SpuInfoDescEntity getById(Long spuId);
}
