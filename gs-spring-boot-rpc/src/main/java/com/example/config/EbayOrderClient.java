package com.example.config;

/**
 * qq
 *
 * @author TomLuo
 * @date 2023年06月04日 20:31
 */

import com.alibaba.fastjson.JSONObject;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 订单相关api
 * @author andanyang
 */
public class EbayOrderClient extends EbayClient {


    /**
     * 店铺配置
     *
     * @param storeId
     */
    public EbayOrderClient(Long storeId) {


        super(storeId);
    }

    /**
     * 订单列表
     *
     * @param beginTime
     * @param endTime
     * @param limit
     * @param offset
     * @return
     */
    public JSONObject orders(String beginTime, String endTime, int limit, int offset) {



        final String path = "/sell/fulfillment/v1/order";

        String filter = MessageFormat.format("lastmodifieddate:[{0}..{1}]", beginTime, endTime);

        //
        Map<String, Object> queryMap = new HashMap<>(8);
        queryMap.put("filter", filter);
        queryMap.put("limit", limit);
        queryMap.put("offset", offset);

        return get("/sell/inventory/v1/inventory_item", queryMap);
    }
}