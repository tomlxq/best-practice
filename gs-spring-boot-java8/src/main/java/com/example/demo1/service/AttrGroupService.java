package com.example.demo1.service;

import com.example.entity.SpuItemAttrGroupVo;

import java.util.List;

/**
 * AttrGroupService
 *
 * @author TomLuo
 * @date 2023年03月12日 23:00
 */
public interface AttrGroupService {
    List<SpuItemAttrGroupVo> getAttrGroupWithAttrsBySpuId(Long spuId, Long catalogId);
}
