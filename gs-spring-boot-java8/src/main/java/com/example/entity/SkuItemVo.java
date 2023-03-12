package com.example.entity;

import lombok.Data;

import java.util.List;

/**
 * SkuItemVo
 *
 * @author TomLuo
 * @date 2023年03月12日 22:52
 */
@Data
public class SkuItemVo {
    SkuInfoEntity info;
    List<SkuImagesEntity> images;
    List<SkuItemSaleAttrVo> saleAttr;
    SpuInfoDescEntity desc;
    List<SpuItemAttrGroupVo> groupAttrs;


}