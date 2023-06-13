package com.example.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * DyRoomGoodsRecord
 *
 * @author TomLuo
 * @date 2023年06月04日 20:47
 */
@Data
public class DyRoomGoodsRecord {
    private Integer liveRoomNum;
    private Date explainTimes;
    private Date firstListingAt;
    private BigDecimal salePrice;
    private BigDecimal turnoverMoney;
    private Integer soldGoodsCount;

    private Integer presellOrderCount;
    private Integer clickerCount;
    private BigDecimal exposeClickerRate;
    private BigDecimal clickerBuyerRate;
    private BigDecimal gpmGoodsPay;
    private Integer preDeliveryRefundOrderCount;
    private BigDecimal preDeliveryRefundMoney;



}