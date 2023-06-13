package com.example.config;

import io.github.admin4j.http.ApiJsonClient;

import java.util.HashMap;
import java.util.Map;

/**
 * www
 *
 * @author TomLuo
 * @date 2023年06月04日 18:25
 */
public class EbayClient extends ApiJsonClient {



    /**
     * 店铺配置
     *
     * @param storeId
     */
    public EbayClient(Long storeId) {



        //TODO 获取店铺相关配置
        Map<String, String> config = new HashMap<>();

        basePath = "https://api.ebay.com";
        defaultHeaderMap.put("Authorization", "Bearer " + config.get("accessToken"));
        defaultHeaderMap.put("X-EBAY-C-MARKETPLACE-ID", config.get("marketplaceId"));
    }
}