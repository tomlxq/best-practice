package com.example.demo1.service;

import com.example.entity.SkuImagesEntity;
import com.example.entity.SkuInfoEntity;
import com.example.entity.SkuItemSaleAttrVo;
import com.example.entity.SkuItemVo;
import com.example.entity.SpuInfoDescEntity;
import com.example.entity.SpuItemAttrGroupVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * DemoCompletableFuture
 *
 * @author TomLuo
 * @date 2023年03月12日 22:52
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DemoCompletableFuture extends BaseCompletableFuture {
    private final SkuImagesService skuImagesService;
    private final SkuSaleAttrValueService skuSaleAttrValueService;
    private final SpuInfoDescService spuInfoDescService;

    private final AttrGroupService attrGroupService;

    public SkuItemVo item(Long skuId) {
        SkuItemVo skuItemVo = new SkuItemVo();

        //1、sku详细信息 sku_info
        SkuInfoEntity skuInfo = getById(skuId);
        skuItemVo.setInfo(skuInfo);

        //2、sku 图片信息 sku_img
        List<SkuImagesEntity> images = skuImagesService.getImagesBySkuId(skuId);
        skuItemVo.setImages(images);

        //3、spu 销售属性组合
        List<SkuItemSaleAttrVo> saleAttr = skuSaleAttrValueService.getSaleAttrBySpuId(skuInfo.getSpuId());
        skuItemVo.setSaleAttr(saleAttr);

        //4、spu 的介绍
        SpuInfoDescEntity spuInfoDesc = spuInfoDescService.getById(skuInfo.getSpuId());
        skuItemVo.setDesc(spuInfoDesc);

        //5、spu 规格参数信息
        List<SpuItemAttrGroupVo> groupAttrs = attrGroupService.getAttrGroupWithAttrsBySpuId(skuInfo.getSpuId(), skuInfo.getCatalogId());
        skuItemVo.setGroupAttrs(groupAttrs);

        return skuItemVo;
    }

    /**
     * 使用CompletableFuture异步编排后
     *
     * @param skuId
     * @return
     */
    private SkuItemVo itemByCompletableFuture(Long skuId) {
        SkuItemVo skuItemVo = new SkuItemVo();

        /**
         * 3、4、5需要依赖1的运行结果，需要返回skuInfo后从中获取spuId和catalogId
         * 而2不需要依赖1的运行结果
         */

        //1、sku详细信息 sku_info
        CompletableFuture<SkuInfoEntity> infoFuture = CompletableFuture.supplyAsync(() -> {
            SkuInfoEntity skuInfo = getById(skuId);
            skuItemVo.setInfo(skuInfo);
            return skuInfo;
        }, executor);

        //2、sku 图片信息 sku_img  2不需要等待上边1的执行结果
        CompletableFuture<Void> imageFuture = CompletableFuture.runAsync(() -> {
            List<SkuImagesEntity> images = skuImagesService.getImagesBySkuId(skuId);
            skuItemVo.setImages(images);
        }, executor);

        //下边的3、4、5都需要上边1的执行结果
        //所以下边的3、4、5都是基于上边1的执行结果 infoFuture 开始的
        //都是以infoFuture.thenAcceptAsync(skuInfo -> {})开始的
        CompletableFuture<Void> saleAttrFuture = infoFuture.thenAcceptAsync(skuInfo -> {
            //3、spu 销售属性组合  3
            List<SkuItemSaleAttrVo> saleAttr = skuSaleAttrValueService.getSaleAttrBySpuId(skuInfo.getSpuId());
            skuItemVo.setSaleAttr(saleAttr);
            System.out.println(saleAttr);
        }, executor);

        CompletableFuture<Void> descFuture = infoFuture.thenAcceptAsync(skuInfo -> {
            //4、spu 的介绍
            SpuInfoDescEntity spuInfoDesc = spuInfoDescService.getById(skuInfo.getSpuId());
            skuItemVo.setDesc(spuInfoDesc);
        }, executor);

        CompletableFuture<Void> attrGroupFuture = infoFuture.thenAcceptAsync(skuInfo -> {
            //5、spu 规格参数信息
            List<SpuItemAttrGroupVo> groupAttrs = attrGroupService.getAttrGroupWithAttrsBySpuId(skuInfo.getSpuId(), skuInfo.getCatalogId());
            System.out.println(groupAttrs);
            skuItemVo.setGroupAttrs(groupAttrs);
        }, executor);

        //等待所有任务完成
        try {
            CompletableFuture.allOf(saleAttrFuture, descFuture, attrGroupFuture, imageFuture).get();
        } catch (InterruptedException e) {
            log.error("查询商品详情异步编排错误: ");
            log.error(e.getMessage());
        } catch (ExecutionException e) {
            log.error(e.getMessage());
        }
        return skuItemVo;
    }

    private SkuInfoEntity getById(Long skuId) {
        return null;
    }
}