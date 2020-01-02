package com.tom.service;




import com.alibaba.fastjson.JSON;
import com.tom.dto.DoOrderRequest;
import com.tom.dto.DoOrderResponse;
import com.tom.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/1
 */
@Service("orderService")
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Override
    public DoOrderResponse doOrder(DoOrderRequest doOrderRequest) {
        log.info("服务请求参数：{}", JSON.toJSONString(doOrderRequest));
        DoOrderResponse response = new DoOrderResponse("0000", "下单成功");
        return response;
    }
}
