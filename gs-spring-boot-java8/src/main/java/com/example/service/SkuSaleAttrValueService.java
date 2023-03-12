package com.example.service;

import com.example.entity.SkuItemSaleAttrVo;

import java.util.List;

/**
 * SkuSaleAttrValueService
 *
 * @author TomLuo
 * @date 2023年03月12日 22:59
 */
public interface SkuSaleAttrValueService {
    List<SkuItemSaleAttrVo> getSaleAttrBySpuId(Long spuId);
}
