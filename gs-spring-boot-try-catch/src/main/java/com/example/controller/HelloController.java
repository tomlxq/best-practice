package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.entity.ResultCode;
import com.example.demo1.service.ProductInfoService;
import com.example.config.APIException;
import com.example.config.NotControllerResponseAdvice;
import com.example.entity.BusinessException;
import com.example.entity.ProductInfo;
import com.example.entity.ProductInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.entity.ErrorEnum.NO_PERMISSION;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/18
 */
@RestController
@Slf4j
public class HelloController {
    @GetMapping("/exp")
    public String exp() {
        throw new BusinessException(NO_PERMISSION.getErrorCode(), NO_PERMISSION.getErrorMsg());
    }

    @Autowired
    private ApplicationArguments args;
    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/hello")
    public String hello() {
        return JSON.toJSONString(args.getNonOptionArgs());
    }



    @PostMapping("/findByVo")
    public ProductInfo findByVo(@Validated ProductInfoVo vo) {
        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(vo, productInfo);
        productInfo=productInfoService.getOne(productInfo);
        if (null == productInfo) {
            throw new APIException(ResultCode.ORDER_NOT_EXIST, "订单号不存在：" + vo.orderId);
        }
        return productInfo;
    }


    @GetMapping("/health")
    @NotControllerResponseAdvice
    public String health() {
        return "success";
    }

}
