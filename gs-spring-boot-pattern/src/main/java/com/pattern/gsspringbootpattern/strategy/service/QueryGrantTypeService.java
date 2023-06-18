package com.pattern.gsspringbootpattern.strategy.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * www
 *
 * @author TomLuo
 * @date 2023年04月28日 21:30
 */
@Service
@Slf4j
public class QueryGrantTypeService {

    @Autowired
    private GrantTypeService grantTypeService;
    private Map<String, Function<String,String>> grantTypeMap=new HashMap<>();

    /**
     * 初始化业务分派逻辑,代替了if-else部分
     * key: 优惠券类型
     * value: lambda表达式,最终会获得该优惠券的发放方式
     */
    @PostConstruct
    public void dispatcherInit() {
        grantTypeMap.put("红包", resourceId -> grantTypeService.redPaper(resourceId));
        grantTypeMap.put("购物券", resourceId -> grantTypeService.shopping(resourceId));
        grantTypeMap.put("qq会员", resourceId -> grantTypeService.QQVip(resourceId));
    }

    /**
     * Map+函数式接口方法
     * Map+函数式接口通过Map.get(key)来代替 if-else的业务分派，能够避免策略模式带来的类增多、难以俯视整个业务逻辑的问题。
     *
     * @param resourceType
     * @return
     */
    public String getResult(String resourceType) {
        // String resourceId="红包";
        //Controller根据 优惠券类型resourceType、编码resourceId 去查询 发放方式grantType
        Function<String, String> result = grantTypeMap.get(resourceType);
        if (result != null) {
            //传入resourceId 执行这段表达式获得String型的grantType
            return result.apply(resourceType);
        }
        return "查询不到该优惠券的发放方式";
    }

    /**
     * if-else或者switch case
     *
     * @param resourceId
     * @return
     */
    public String getResult2(String resourceId) {
        switch (resourceId) {
            case "红包":
                //查询红包的派发方式
                return grantTypeService.redPaper(resourceId);
            case "购物券":
                //查询购物券的派发方式
                return grantTypeService.shopping(resourceId);
            case "QQ会员":
                return grantTypeService.QQVip(resourceId);
            default:
                log.info("查找不到该优惠券类型resourceType以及对应的派发方式");
                return "查询不到该优惠券的发放方式";
        }
    }

    /**
     * 策略模式
     * 策略模式通过接口、实现类、逻辑分派来完成，把 if语句块的逻辑抽出来写成一个类，更好维护。
     *
     * @param resourceId
     * @return
     */
    public String getResult3(String resourceId) {
        switch (resourceId) {
            case "红包":
                String grantType = new Context(new RedPaper()).contextInterface();
                return grantType;
            case "购物券":
                grantType = new Context(new Shopping()).contextInterface();
                return grantType;
            case "QQ会员":
                return new Context(new QQVip()).contextInterface();
            default:
                log.info("查找不到该优惠券类型resourceType以及对应的派发方式");
                return "查询不到该优惠券的发放方式";
        }
    }
}