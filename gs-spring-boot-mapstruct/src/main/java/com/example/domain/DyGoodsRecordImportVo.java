package com.example.domain;

import lombok.Data;

import java.util.Date;

/**
 * DyGoodsRecordImportVo
 *
 * @author TomLuo
 * @date 2023年06月04日 20:47
 */
@Data
public class DyGoodsRecordImportVo {
    private Integer liveRoomNum;
    private Date explainTimes;
    private Date firstListingAt;
    private String salePrice;
    private String turnoverMoney;
    private Integer soldGoodsCount;
    private Integer presell0rderCount;

    private Integer   clickerCount;
    private String exposeClickerRate;
    private String clickerBuyerRate;
    private String gpmGoodsPay;
    private Integer preDeliveryRefundOrderCount;
    private String preDeliveryRefundMoney;



}