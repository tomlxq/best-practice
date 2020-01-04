package com.tom.service;


import com.alibaba.fastjson.JSON;
import com.tom.dal.OrderDao;
import com.tom.dto.DoOrderRequest;
import com.tom.dto.DoOrderResponse;
import com.tom.dto.RechargeReq;
import com.tom.dto.RechargeRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/1
 */
@Service("orderService")
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Autowired
    UserService userService;
    @Autowired
    JtaTransactionManager springTransactionManager;

    @Override
    public DoOrderResponse doOrder(DoOrderRequest doOrderRequest) {
        log.info("调到订单模块中心 ：{}", JSON.toJSONString(doOrderRequest));
        UserTransaction userTransaction = springTransactionManager.getUserTransaction();
        try {
            userTransaction.begin();
            orderDao.save();
            RechargeRes rechargeRes = userService.recharge(new RechargeReq());
            userTransaction.commit();
        } catch (NotSupportedException | SystemException e) {
            log.error("{}", e);
        } catch (Exception e) {
            log.error("{}", e);
            try {
                userTransaction.rollback();
            } catch (SystemException ex) {
                log.error("{}", ex);
            }
        }
        DoOrderResponse response = new DoOrderResponse("0000", "下单成功");

        return response;
    }
}
