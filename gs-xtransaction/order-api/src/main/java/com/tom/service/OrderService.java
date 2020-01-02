package com.tom.service;

import com.tom.dto.DoOrderRequest;
import com.tom.dto.DoOrderResponse;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/1
 */
public interface OrderService {
    DoOrderResponse doOrder(DoOrderRequest doOrderRequest);
}
